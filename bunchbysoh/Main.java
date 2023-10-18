package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
    public int[] currentBatteryCapacity;
    public int[] batterySoh;

    CountsBySoH(int[] presentCapacities) {
      this.currentBatteryCapacity = presentCapacities;
      this.batterySoh = new int[presentCapacities.length];
    }

    public void calculateSoh(){
       for (int i = 0; i < currentBatteryCapacity.length; i++) {
           int soh = (100 * currentBatteryCapacity[i]) / 120;
           this.batterySoh[i] = soh;
        }
    }

    public void classifyBatteryBySoh(){
       for (int soh : this.batterySoh) {
        if (soh > 80 && soh <= 100) {
            this.healthy += 1;
        }
        else if (soh > 63 && soh < 80) {
            this.exchange += 1;
        }
        else {
            this.failed += 1;
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
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    counts.calculateSoh();
    counts.classifyBatteryBySoh();
    
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
