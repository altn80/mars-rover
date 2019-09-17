# mars-rover assessment

##Build Instructions

  ```
  mvn clean install
  ```

## Run Instructions

  ```
  java -jar mars-rover-1.0.jar < input.txt
  ```




Test Input:
```
Plateau:5 5
Rover1 Landing:1 2 N
Rover1 Instructions:LMLMLMLMM
Rover2 Landing:3 3 E
Rover2 Instructions:MMRMMRMRRM
```

Expected Output:
```
Rover1:1 3 N
Rover2:5 1 E
```


