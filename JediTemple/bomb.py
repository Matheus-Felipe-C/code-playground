import customtkinter as ctk

class Bomb(ctk.CTk):
    def __init__(self, board, symbol: str, row: int, column: int):
        self.board = board
        self.symbol = symbol
        self.row = row
        self.column = column

        # Place the treasure on the map visually
        self.label = ctk.CTkLabel(master= self.board.frame_matrix[row][column], text=symbol, font=("Arial", 16))
        self.label.pack(expand=True)
    
    def remove(self):
        """Removes the bomb from the board."""
        self.board.frame_matrix[self.row][self.column].configure(text='')
