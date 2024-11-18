import math
import customtkinter as ctk

class Treasure:
    def __init__(self, frame_matrix, symbol: str, row: int, column: int):
        self.frame_matrix = frame_matrix
        self.symbol = symbol
        self.row = row
        self.column = column
        self.weight = self.calc_weight(row)

        # Place the treasure on the map visually
        self.label = ctk.CTkLabel(self.frame_matrix[row][column], text=symbol, font=("Arial", 16))
        self.label.pack(expand=True)

    def remove(self):
        """Removes the treasure from the map display."""
        self.label.destroy()
        print(f"Treasure at ({self.row}, {self.column}) of weight {self.weight} captured and removed from the map.")

    def calc_weight(self, current_row):
        """Calculates the weight of treasures based on their current depth."""
        if current_row == 0:
            weight = 1
        else:
            weight = math.ceil(current_row / 3)
        
        return weight