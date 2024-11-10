import customtkinter as ctk

class Treasure:
    def __init__(self, frame_matrix, symbol: str, row: int, column: int):
        self.frame_matrix = frame_matrix
        self.symbol = symbol
        self.row = row
        self.column = column

        # Place the treasure on the map visually
        self.label = ctk.CTkLabel(self.frame_matrix[row][column], text=symbol, font=("Arial", 16))
        self.label.pack(expand=True)

    def remove(self):
        """Removes the treasure from the map display."""
        self.label.destroy()
        print(f"Treasure at ({self.row}, {self.column}) captured and removed from the map.")