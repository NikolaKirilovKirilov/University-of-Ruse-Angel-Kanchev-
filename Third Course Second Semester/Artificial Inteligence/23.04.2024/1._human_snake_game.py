import pygame
import random
from enum import Enum
from collections import namedtuple

pygame.init()
font = pygame.font.Font('arial.ttf', 25)
#font = pygame.font.SysFont('arial', 25)

# Клас, в който дефинираме всички възможни посоки, по които може да поеме нашата змия
class Direction(Enum):
    RIGHT = 1
    LEFT = 2
    UP = 3
    DOWN = 4

# Използваме tuple структура, за да помещаваме и евентуално показваме пространствените координати
Point = namedtuple('Point', 'x, y')

# Дефиниране на цветове, които ще използваме за обозначаване на елементи в зоната за игра
WHITE = (255, 255, 255)
RED = (200,0,0)
BLUE1 = (0, 0, 255)
BLUE2 = (0, 100, 255)
BLACK = (0,0,0)

# Колко да са големи нашите блокчета и с каква скорост ще се движи змиорката за един кадър (frame)
BLOCK_SIZE = 20
SPEED = 5

# Клас, който отговаря за цялата игра, в него се намира функционалността на играта
class SnakeGame:
    
    # Дефинираме функция за началните стойности за обектите, които са за нашата игра
    def __init__(self, w=640, h=480):
        # Даваме стойност на това колко ще е голямо игралното поле/зона
        self.w = w
        self.h = h
        # Задаваме начало на показването на игра с посочените размери
        self.display = pygame.display.set_mode((self.w, self.h))
        # Казваме какво ще бъде заглавието на нашия прозорец, в който тече играта
        pygame.display.set_caption('Snake')
        # Добавяме часовниче към играта
        self.clock = pygame.time.Clock()
        
        # Започваме играта с начална посока - дясно
        self.direction = Direction.RIGHT
        
        # Задаваме начална позиция на змията, която ще бъде в "средата" на полето за игра, т.е. половината на дължината и половината на ширината на полето
        self.head = Point(self.w/2, self.h/2)
        # Инициализираме самата змия, давайки и дължина и дефинираме точната позиция на тялото ѝ спрямо главата, която сме инициализирали в предходния ред
        self.snake = [self.head, 
                      Point(self.head.x-BLOCK_SIZE, self.head.y),
                      Point(self.head.x-(2*BLOCK_SIZE), self.head.y)]
        
        # Задаваме началните данни за играта - нулираме резултата
        self.score = 0
        # Нулираме вече съществуваща храна, която може да е останала от предходни игри
        self.food = None
        # Поставяме нова храна
        self._place_food()
        
    # Метод, в който поставяме на случайни позиции една наградка/храна
    def _place_food(self):
        # Генерираме 2 случайни числа, които се намират вътре в игралното поле
        x = random.randint(0, (self.w-BLOCK_SIZE )//BLOCK_SIZE )*BLOCK_SIZE 
        y = random.randint(0, (self.h-BLOCK_SIZE )//BLOCK_SIZE )*BLOCK_SIZE
        # Инициализиране вътре в текущото поле храната
        self.food = Point(x, y)
        # Ако змията е успяла да изяде храната, поставяме нова храна
        if self.food in self.snake:
            self._place_food()
        
    # Дефиниране на всяка стъпка от изпълнението на играта
    def play_step(self):
        # Вземаме всяко потребителско действие
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
            # Проверяваме за натиснат бутон и дали той съответства на някои от движенията
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_LEFT:
                    self.direction = Direction.LEFT
                elif event.key == pygame.K_RIGHT:
                    self.direction = Direction.RIGHT
                elif event.key == pygame.K_UP:
                    self.direction = Direction.UP
                elif event.key == pygame.K_DOWN:
                    self.direction = Direction.DOWN
        
        # Придвижваме змията в посоката, която сме указали
        self._move(self.direction) # Обновяваме главата на змиорката
        self.snake.insert(0, self.head)
        
        # Проверяваме условията за приключване на играта
        game_over = False
        # Ако се е докоснала змията до себе си или границите на полето
        if self._is_collision():
            game_over = True
            return game_over, self.score
            
        # Проверка дали змията е изяла нещо, отброяване на резултат
        if self.head == self.food:
            self.score += 1
            self._place_food()
        else:
            # Ако НЕ е изяла храна, премахваме последната част от опашката на змията, за да реализираме придвижване
            self.snake.pop()
        
        # Обновяваме интерфейса и часовника
        self._update_ui()
        self.clock.tick(SPEED)
        # Подаваме обратно резултата и дали сме приключили с играта
        return game_over, self.score
    
    # Проверка за докосване до себе си или границите
    def _is_collision(self):
        # Проверка за граници
        if self.head.x > self.w - BLOCK_SIZE or self.head.x < 0 or self.head.y > self.h - BLOCK_SIZE or self.head.y < 0:
            return True
        # Проверка за себе си
        if self.head in self.snake[1:]:
            return True
        
        return False
    
    # Обновяване на интерфейса
    def _update_ui(self):
        # Правим игралното поле черно
        self.display.fill(BLACK)
        
        # За всяко блокче от змията я рисуваме в съответния цвят, като имаме два вложени квадрата
        for pt in self.snake:
            pygame.draw.rect(self.display, BLUE1, pygame.Rect(pt.x, pt.y, BLOCK_SIZE, BLOCK_SIZE))
            pygame.draw.rect(self.display, BLUE2, pygame.Rect(pt.x+4, pt.y+4, 12, 12))
            
        # Рисуваме квадратче с храната в определения цвят
        pygame.draw.rect(self.display, RED, pygame.Rect(self.food.x, self.food.y, BLOCK_SIZE, BLOCK_SIZE))
        
        # Обновяваме резултата
        text = font.render("Score: " + str(self.score), True, WHITE)
        self.display.blit(text, [0, 0])
        pygame.display.flip()
        
    # Преместване на змията
    def _move(self, direction):
        x = self.head.x
        y = self.head.y
        if direction == Direction.RIGHT:
            x += BLOCK_SIZE
        elif direction == Direction.LEFT:
            x -= BLOCK_SIZE
        elif direction == Direction.DOWN:
            y += BLOCK_SIZE
        elif direction == Direction.UP:
            y -= BLOCK_SIZE
            
        self.head = Point(x, y)
            

if __name__ == '__main__':
    game = SnakeGame()
    
    # game loop
    while True:
        game_over, score = game.play_step()
        
        if game_over == True:
            break
        
    print('Final Score', score)
        
        
    pygame.quit()