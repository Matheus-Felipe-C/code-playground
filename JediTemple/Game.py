import random
import customtkinter as ctk
from player import Player
from Treasure import Treasure

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
        self.possible_moves = [] # List to store valid moves

        # Spawn treasure chests
        self.treasures = [] #List to store multiple treasures
        self.create_treasures(num_treasures = 5) # Adds treasures randomly in the map

        # Add players
        self.add_player(symbol= "👾", name = "Player 1", initial_row = 0, initial_column = 0)
        self.add_player(symbol= "🦄", name= "Player 2", initial_row= 1, initial_column = 1)

        # Instructions label
        self.instructions_label = ctk.CTkLabel(self, text= "Click to move active player, press 'Tab' to switch players")
        self.instructions_label.grid(row = rows + 1, column=0, columnspan=columns, pady= 10)

        self.bind("<Tab>", lambda event: self.switch_active_player(has_moved= False))

        self.attempt_move()

    def create_treasures(self, num_treasures: int = 1):
        """Creates random treasures on the map with a unique symbol."""
        for _ in range(num_treasures):
            row, column = random.randint(0, len(self.frame_matrix) - 1), random.randint(0, len(self.frame_matrix[0]) - 1)

            # Ensure treasures won't overlap
            while any(treasure.row == row and treasure.column == column for treasure in self.treasures):
                row, column = random.randint(0, len(self.frame_matrix) - 1), random.randint(0, len(self.frame_matrix[0] - 1))
            
            treasure = Treasure(self.frame_matrix, "💎", row, column)
            self.treasures.append(treasure)

    def roll_dice(self):
        """Returns a random number from 0 to 3, which will determine how far a player will go"""
        return random.randint(0, 3)

    def show_possible_moves(self, player, dice_roll):
        """Highlight frames within dice_roll range, only in vertical and horizontal directions."""
        row, column = player.row, player.column
        self.possible_moves = [] # Resets possible move tuple

        # Collect possible moves (up, down, left, right within the dice roll range)
        for step in range(1, dice_roll + 1):
            # Up
            if row - step >= 0:
                self.possible_moves.append((row - step, column))
            # Down
            if row + step < len(self.frame_matrix):
                self.possible_moves.append((row + step, column))
            # Left
            if column - step >= 0:
                self.possible_moves.append((row, column - step))
            # Right
            if column + step < len(self.frame_matrix[0]):
                self.possible_moves.append((row, column + step))
        
        # Highlight each possible move
        for r, c in self.possible_moves:
            self.frame_matrix[r][c].configure(border_color= "blue", border_width= 2)

    def clear_highlights(self):
        """Clears all highlighted frames by resetting the border."""
        for row in self.frame_matrix:
            for frame in row:
                frame.configure(border_color= "black", border_width = 0)

    def create_matrix(self, rows= 15, columns= 15):
        """Creates the map matrix and shows it on the screen"""
        for row in range(rows):
            row_frames = []

            for column in range(columns):
                frame = ctk.CTkFrame(master= self, width= 40, height= 40, corner_radius=5)
                frame.grid(row= row, column= column, padx= 2, pady= 2)
                frame.grid_propagate(False)
                frame.pack_propagate(False)
                frame.bind("<Button-1>", lambda event, r=row, c= column: self.handle_click(r, c))

                # Adds an onclick event to move the active player
                row_frames.append(frame)

            self.frame_matrix.append(row_frames)

    def add_player(self, symbol: str, name: str, initial_row: int, initial_column: int) -> None:
        """Adds a new player to the map"""
        player = Player(self.frame_matrix, symbol, name, initial_row, initial_column)
        self.players.append(player)

    def handle_click(self, row: int, column: int) -> None:
        """Handles click event, moving the player only if the selected cell is a valid move."""
        if (row, column) in self.possible_moves:
            self.move_active_player(row, column)
        else:
            print(f"cell {row},{column} not in range")
            

    def move_active_player(self, row: int, column: int) -> None:
        """Move active player to designated cell"""
        active_player = self.players[self.active_player_index]

        if self.is_occupied(row, column):
            # Determine the direction and attempt a jump
            d_row, d_col = row - active_player.row, column - active_player.column
            new_row, new_column = row + d_row, column + d_col

            # Ensure new jump position is within bounds
            if 0 <+ new_row < len(self.frame_matrix) and 0 <= new_column < len(self.frame_matrix[0]):
                # Set new target position to the jump position if unoccupied
                if not self.is_occupied(new_row, new_column):
                    row, column = new_row, new_column
        
        active_player.move_to(row, column)
        print(f"Moving {active_player.name} to ({row}, {column})")

        self.consume_oxygen(row, column, active_player)
        self.check_for_treasure(row, column, active_player)        
        self.switch_active_player(has_moved = True)
    
    def is_occupied(self, row: int, column: int) -> bool:
        """Checks if a specific position is occupied by any player."""
        return any(player.row == row and player.column == column for player in self.players)

    def check_for_treasure(self, row: int, column: int, player: Player):
        """Check if a player landed on a treasure and prompt capture dialog if so."""
        for treasure in self.treasures:
            if treasure.row == row and treasure.column == column:
                self.attempt_capture_treasure(treasure, player)

    def attempt_capture_treasure(self, treasure: Treasure, player: Player):
        """Display a dialog asking if the player wants to capture the treasure."""
        dialog = ctk.CTkToplevel(self)
        dialog.title("Capture treasure")

        label = ctk.CTkLabel(dialog, text=f"{player.name} found a treasure! Capture it?")
        label.pack(pady = 0)

        yes_button = ctk.CTkButton(dialog, text="Yes", command = lambda: self.capture_treasure(treasure, dialog))
        no_button = ctk.CTkButton(dialog, text= "No", command = dialog.destroy)

        yes_button.pack(side="left", padx = 10)
        no_button.pack(side="right", padx = 10)

    def capture_treasure(self, treasure: Treasure, dialog: ctk.CTkToplevel):
        """Capture the treasure and remove it from the map."""
        self.players[self.active_player_index].increase_weight(treasure.weight)
        self.treasures.remove(treasure)
        treasure.remove() # Remove symbol from the map display
        dialog.destroy()

    def switch_active_player(self, has_moved: bool = False):
        """Switches to the next player in the list"""
        if not has_moved:
            self.oxygen -= 1
            print(f"Oxygen consumed: 1. Oxygen remaining: {self.oxygen}")

        self.active_player_index = (self.active_player_index + 1) % len(self.players)
        active_player = self.players[self.active_player_index]
        print(f"Active player is now {active_player.name}")
        self.clear_highlights() # Clear highlights after moving
        self.attempt_move()

    def attempt_move(self):
        """Rolls dice and shows possible moves for the active player."""
        dice_roll = self.roll_dice()
        active_player = self.players[self.active_player_index]
        self.show_possible_moves(active_player, dice_roll)

    def consume_oxygen(self, cell_row: int, cell_column: int, active_player: Player) -> None:
        """Consumes oxygen tanks relative to the weight of the player and amount of cells he travelled."""
        cells = abs(cell_row - active_player.row) + abs(cell_column - active_player.column)
        print(f"Current player's weight: {active_player.weight}")

        consumption = cells * active_player.weight + 1
        self.oxygen -= consumption
        print(f"Oxygen consumed: {consumption}. Remaining oxygen: {self.oxygen}")