import customtkinter as ctk

class Player(ctk.CTk):
    def __init__(self, matrix, symbol, name, initial_row, initial_column, **kwargs):

        self.matrix = matrix
        self.symbol = symbol
        self.name = name
        self.weight = 1
        self.row = initial_row
        self.column = initial_column
        self.player_label = ctk.CTkLabel(master=self.matrix[self.row][self.column], text= self.symbol, font=("Arial", 20))
        self.player_label.pack(expand=True)

    def move_to(self, new_row: int, new_column: int) -> None:
        """Moves the character to the designed position in the map"""

        # Remove player from current position
        self.player_label.pack_forget()

        self.row, self.column = new_row, new_column

        # Place player in new updated position

        self.player_label = ctk.CTkLabel(master=self.matrix[self.row][self.column], text= self.symbol, font=("Arial", 20))
        self.player_label.pack(expand= True)

    def increase_weight(self, new_weight: int) -> None:
        """Increases the weight of the player"""
        self.weight += new_weight
        print(f"Player's new weight: {self.weight}")
