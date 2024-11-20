import random
from treasure import Treasure

class TreasureManager:
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
                self.capture_treasure(treasure, player)
            
    def capture_treasure(self, treasure, player):
        player.increase_weight(treasure.weight)
        self.treasures.remove(treasure)
        treasure.remove()
    
    def get_random_position(self):
        """Assigns a random position for the treasure."""
        row = random.randint(0, self.board.rows - 1)
        col = random.randint(0, self.board.columns - 1)

        return row, col