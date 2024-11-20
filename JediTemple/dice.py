import random

class Dice:
    def __init__(self, min_value = 0, max_value= 3) -> None:
        self.min_value = min_value
        self.max_value = max_value
    
    def roll(self) -> int:
        return random.randint(self.min_value, self.max_value)
    