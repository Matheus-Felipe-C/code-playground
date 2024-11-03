import customtkinter as ctk
from player import Player

class Game(ctk.CTkFrame):
    def __init__(self, master, rows = 15, columns = 15, **kwargs):
        super().__init__(master, **kwargs)
        
        # Manage map matrix
        self.frame_matrix = []
        self.create_matrix(rows, columns)

        # Manage the players
        self.players = []
        self.active_player_index = 0 # Tracks which player to play next
        self.oxygen = 15

        # Add players
        self.add_player(symbol= "👾", name = "Player 1", oxygen= self.oxygen, initial_row = 0, initial_column = 0)
        self.add_player(symbol= "🦄", name= "Player 2", oxygen = self.oxygen, initial_row= 1, initial_column = 1)

        # Instructions label
        self.instructions_label = ctk.CTkLabel(self, text= "Click to move active player, press 'Tab' to switch players")
        self.instructions_label.grid(row = rows + 1, column=0, columnspan=columns, pady= 10)

        self.bind("<Tab>", self.switch_active_player)

    def create_matrix(self, rows= 15, columns= 15):
        """Creates the map matrix and shows it on the screen"""
        for row in range(rows):
            row_frames = []

            for column in range(columns):
                frame = ctk.CTkFrame(master= self, width= 40, height= 40, corner_radius=5)
                frame.grid(row= row, column= column, padx= 2, pady= 2)
                frame.grid_propagate(False)
                frame.pack_propagate(False)
                frame.bind("<Button-1>", lambda event, r=row, c= column: self.move_active_player(r, c))

                # Adds an onclick event to move the active player
                row_frames.append(frame)

            self.frame_matrix.append(row_frames)

    def add_player(self, symbol: str, name: str, oxygen: int, initial_row: int, initial_column: int) -> None:
        """Adds a new player to the map"""
        player = Player(self.frame_matrix, symbol, name, oxygen, initial_row, initial_column)
        self.players.append(player)

    def move_active_player(self, row: int, column: int) -> None:
        """Move active player to designated cell"""
        active_player = self.players[self.active_player_index]
        active_player.move_to(row, column)
        print(f"Moving {active_player.name} to ({row}, {column})")
        
        self.switch_active_player()

    def switch_active_player(self, event=None):
        """Switches to the next player in the list"""
        self.active_player_index = (self.active_player_index + 1) % len(self.players)
        active_player = self.players[self.active_player_index]
        print(f"Active player is now {active_player.name}")

    def change_frame_color(self, row: int, column: int, color: str) -> None:
        self.frame_matrix[row][column].configure(fg_color= color)


