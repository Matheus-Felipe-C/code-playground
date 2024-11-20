import random
from treasure import Treasure
import customtkinter as ctk

class TreasureManager(ctk.CTk):
    def __init__(self, board, difficulty):
        self.board = board
        self.treasures = []
        self.spawn_treasures(difficulty)
    
    def spawn_treasures(self, difficulty):
        """Spawns the treasure in the board map."""
        spawn_percentage = 0.01
        if difficulty == 'easy':
            spawn_percentage = 0.01
        elif difficulty == 'medium':
            spawn_percentage = 0.05
        else:
            spawn_percentage = 0.15
        
        num_treasures = round(self.board.rows * self.board.columns * spawn_percentage)
        
        for _ in range(num_treasures):
            row, column = self.get_random_position()
            while self.is_position_occupied(row, column):
                row, column = self.get_random_position()
            treasure = Treasure(self.board, "💎", row, column)
            self.treasures.append(treasure)
        
    def is_position_occupied(self, row, column):
        return any(t.row == row and t.column == column for t in self.treasures)
    
    def check_for_treasure(self, row, column, player):
        for treasure in self.treasures:
            if treasure.row == row and treasure.column == column:
                self.prompt_capture_treasure(treasure, player)
            
    def prompt_capture_treasure(self, treasure, player):
        """Prompts the player to decide whether to capture the treasure."""
        dialog = ctk.CTkToplevel(self.board.master)
        dialog.title("Treasure found!")
        dialog.geometry("300x150")

        label = ctk.CTkLabel(dialog, text=f"{player.name} found a treasure! Capture it?")
        label.pack(pady = 10)

        # Yes/no button callbacks
        def on_yes():
            if player.weight + treasure.weight > player.MAX_WEIGHT:
                print(f"{player.name} cannot capture the treasure. Exceeds weight limit!")
                dialog.destroy()
                return

            self.capture_treasure(treasure, player)
            dialog.destroy()
        
        def on_no():
            print(f"{player.name} chose not to capture the treasure.")
            dialog.destroy()

        yes_button = ctk.CTkButton(dialog, text="Yes", command= on_yes)
        yes_button.pack(side="left", padx = 10)

        no_button = ctk.CTkButton(dialog, text= "No", command= on_no)
        no_button.pack(side="right", padx = 10)

    def capture_treasure(self, treasure, player):
        player.increase_weight(treasure.weight)
        self.treasures.remove(treasure)
        treasure.remove()
    
    def get_random_position(self):
        """Assigns a random position for the treasure."""
        row = random.randint(1, self.board.rows - 1)
        col = random.randint(1, self.board.columns - 1)

        return row, col