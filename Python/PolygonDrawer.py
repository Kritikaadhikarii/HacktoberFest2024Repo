"""
A turtle graphics python 3 program .
Author: Sajith Minrutha

"""

from turtle import setup, speed, pencolor, penup, pendown, left, forward, exitonclick ,textinput , numinput

# Assign canvas and shape size
canvas_size = numinput("canvas size","Enter the canvas size:")
sides = numinput("sides","Enter the number of sides:")
side_length = 2 / sides * canvas_size
turn_angle= 360/sides
color = textinput("colour","Enter the colour of your polygon:") 
# Set the window size and turtle speed
setup(canvas_size, canvas_size)
speed(1)

# Move turtle into position
penup()
left(90)
forward(canvas_size / 3)
left(150)

# Draw a blue polygon
pencolor(color)
pendown()
for side in range(int(sides)):
    forward(side_length)
    left(turn_angle)

# Finished!
exitonclick()