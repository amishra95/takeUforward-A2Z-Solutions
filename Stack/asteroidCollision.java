class Solution {
  public int[] asteroidCollision(int[] asteroids) {

    // Monotonic Stack and
    if (asteroids == null || asteroids.length == 0) {
      return null;
    }

    Stack<Integer> stack = new Stack<>();
    

    for (int i = 0; i < asteroids.length; i++) {
      while (!stack.isEmpty()
          && stack.peek() > 0
          && asteroids[i] < 0
          && Math.abs(asteroids[i]) > stack.peek()) {
        stack.pop();
      }
      if (!stack.isEmpty()
          && stack.peek() > 0
          && asteroids[i] < 0
          && stack.peek() == Math.abs(asteroids[i])) {
        stack.pop();
      } else if (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
        continue;
      } else {
        stack.push(asteroids[i]);
      }
    
  }
  int[] result = new int[stack.size()];

for (int i = stack.size() - 1; i >= 0; i--) {
    result[i] = stack.pop();
}

return result;
  }
}
