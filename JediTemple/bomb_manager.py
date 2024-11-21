from bomb import Bomb
import random

class BombManager:
    def __init__(self, board, difficulty) -> None:
        self.board = board
        self.bombs = []
        self.spawn_bombs(difficulty)
    
    def spawn_bombs(self, difficulty):
        """Places the bombs on the board."""
        spawn_percentage = 0.01 if difficulty == "easy" else 0.05 if difficulty == "medium" else 0.15
        num_bombs = round(self.board.rows * self.board.columns * spawn_percentage)

        for _ in range(num_bombs):
            row, column = self.get_random_position()
            
            if not self.board.is_occupied(row, column):
                bomb = Bomb(self.board, "💣", row, column)
                self.bombs.append(bomb)
                self.board.place_item(row, column)

    def get_random_position(self):
        row = random.randint(3, self.board.rows - 1)
        column = random.randint(3, self.board.columns - 1)
        return row, column

    def check_for_bomb(self, row, column, player_manager):
        """Kills the player if they step on a bomb."""
        for bomb in self.bombs:
            if bomb.row == row and bomb.column == column:
                self.trigger_bomb(player_manager, bomb)
                return True
        return False

    def trigger_bomb(self, player_manager, bomb):
        """Handles the bomb's effect."""
        player = player_manager.get_active_player()
        print(f"{player.name} stepped on a bomb and died!")
        bomb.remove()
        player_manager.kill_player(player)