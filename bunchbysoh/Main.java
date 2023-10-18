package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
    public int invalidCount = 0;
    public int[] calculateBatterySoh;

    CountsBySoH(int[] presentCapacities) {
      this.calculateBatterySoh = presentCapacities;
    }

    // Optimised the previous approah, 
    // Time Complexity - O(n), SpaceComplexity - O(1)
    
    public void classifyBatteryBySoh(){
       for (int capacity : this.calculateBatterySoh) {
        int soh = (100 * capacity) / 120;
           
        if (soh > 80 && soh <= 100) {
            this.healthy += 1;
        }
        else if (soh > 63 && soh < 80) {
            this.exchange += 1;
        }
        else if(soh < 63 && soh > 0) {
            this.failed += 1;
        }
        else{
            this.invalidCount +=1;
        }
      }
    }
  }

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH(presentCapacities);
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70, 8000};  //added one more capacity - 8000
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    counts.classifyBatteryBySoh();
    
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    
    // count invalid capacity 
    assert(counts.invalidCount == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
