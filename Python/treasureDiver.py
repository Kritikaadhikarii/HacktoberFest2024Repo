import random
import os

# Constants for the maze
WIDTH = 10
HEIGHT = 10
PLAYER = 'D'
TREASURE = 'T'
WALL = '#'
EMPTY = ' '
OXYGEN = 'O'
SEA_CREATURE = 'C'

# Player attributes
player_position = [1, 1]
oxygen_level = 20
treasures_collected = 0
total_treasures = 3

def create_maze():
    maze = [[EMPTY for _ in range(WIDTH)] for _ in range(HEIGHT)]
    # Set walls around the maze
    for i in range(HEIGHT):
        maze[i][0] = WALL
        maze[i][WIDTH - 1] = WALL
    for j in range(WIDTH):
        maze[0][j] = WALL
        maze[HEIGHT - 1][j] = WALL

    # Add player to the maze
    maze[player_position[1]][player_position[0]] = PLAYER

    # Place treasures, oxygen tanks, and sea creatures
    place_items(maze, TREASURE, total_treasures)
    place_items(maze, OXYGEN, 3)
    place_items(maze, SEA_CREATURE, 4)

    return maze

def place_items(maze, item, count):
    placed = 0
    available_positions = [(x, y) for x in range(1, WIDTH - 1) for y in range(1, HEIGHT - 1)]
    while placed < count and available_positions:
        x, y = random.choice(available_positions)
        if maze[y][x] == EMPTY:
            maze[y][x] = item
            placed += 1
            available_positions.remove((x, y))

def print_maze(maze):
    os.system('cls' if os.name == 'nt' else 'clear')
    for row in maze:
        print(' '.join(row))
    print(f"Oxygen Level: {oxygen_level}")
    print(f"Treasures Collected: {treasures_collected}/{total_treasures}")

def move_player(direction, maze):
    global player_position, oxygen_level, treasures_collected
    x, y = player_position
    dx, dy = 0, 0
    if direction == "up": dy = -1
    elif direction == "down": dy = 1
    elif direction == "left": dx = -1
    elif direction == "right": dx = 1
    else:
        print("Invalid move!")
        return False

    new_x, new_y = x + dx, y + dy

    # Check boundaries and walls
    if maze[new_y][new_x] == WALL:
        print("You can't swim through walls!")
        return False

    # Check for sea creatures
    if maze[new_y][new_x] == SEA_CREATURE:
        print("You encountered a sea creature and lost the game!")
        return True

    # Update player's position
    maze[y][x] = EMPTY
    player_position = [new_x, new_y]
    if maze[new_y][new_x] == TREASURE:
        treasures_collected += 1
        print("You found a treasure!")
    elif maze[new_y][new_x] == OXYGEN:
        oxygen_level += 5
        print("You found an oxygen tank!")

    maze[new_y][new_x] = PLAYER
    oxygen_level -= 1

    if treasures_collected == total_treasures and player_position == [1, 1]:
        print("Congratulations! You've collected all treasures and returned to the base!")
        return True
    elif oxygen_level <= 0:
        print("You've run out of oxygen!")
        return True

    return False

def main():
    maze = create_maze()
    game_over = False

    while not game_over:
        print_maze(maze)
        command = input("Enter your move (up, down, left, right): ").strip().lower()
        game_over = move_player(command, maze)

    print("Game over!")

if __name__ == "__main__":
    main()
