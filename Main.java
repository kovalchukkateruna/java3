import java.util.Arrays;
import java.util.Comparator;


class BuildingBlock {
    private String material; 
    private String color;   
    private int hardness;    
    private int weight;      
    private double size;    

   
    public BuildingBlock(String material, String color, int hardness, int weight, double size) {
        this.material = material;
        this.color = color;
        this.hardness = hardness;
        this.weight = weight;
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHardness() {
        return hardness;
    }

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "BuildingBlock{" +
                "material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", hardness=" + hardness +
                ", weight=" + weight +
                ", size=" + size +
                '}';
    }
}


public class Main {
    public static void main(String[] args) {
        
        BuildingBlock[] blocks = {
            new BuildingBlock("Wood", "Brown", 3, 15, 2.5),
            new BuildingBlock("Stone", "Gray", 7, 25, 3.0),
            new BuildingBlock("Glass", "Transparent", 2, 10, 1.8),
            new BuildingBlock("Brick", "Red", 5, 20, 2.7),
            new BuildingBlock("Concrete", "Gray", 6, 30, 3.5)
        };

    
        Arrays.sort(blocks, Comparator.comparingInt(BuildingBlock::getHardness)
                .thenComparing(Comparator.comparingInt(BuildingBlock::getWeight).reversed()));

        System.out.println("Sorted blocks:");
        for (BuildingBlock block : blocks) {
            System.out.println(block);
        }

        BuildingBlock target = new BuildingBlock("Stone", "Gray", 7, 25, 3.0);
        boolean found = Arrays.stream(blocks).anyMatch(block -> block.toString().equals(target.toString()));

        if (found) {
            System.out.println("Target block found: " + target);
        } else {
            System.out.println("Target block not found.");
        }
    }
}
