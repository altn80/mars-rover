# mars-rover assessment

## Build/Run Requirements
* apache maven 3
* jdk 1.8

## Build Instructions

  ```
  mvn clean package
  ```

## Run Instructions

* Command Line - typed
  ```
  java -jar mars-rover-1.0.jar
  Plateau:5 5
  Rover1 Landing:1 2 N
  Rover1 Instructions:LMLMLMLMM
  Rover2 Landing:3 3 E
  Rover2 Instructions:MMRMMRMRRM
  ```
* Command Line - file
  ```
  java -jar mars-rover-1.0.jar < input.txt
  ```
  **input.txt Example**:
  ```
  Plateau:5 5
  Rover1 Landing:1 2 N
  Rover1 Instructions:LMLMLMLMM
  Rover2 Landing:3 3 E
  Rover2 Instructions:MMRMMRMRRM
  ```

  **Expected Output Example**:
  ```
  Rover1:1 3 N
  Rover2:5 1 E
  ```


