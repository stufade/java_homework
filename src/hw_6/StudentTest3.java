package hw_6;

class StudentForMerge {
    private String name;
    private double gpa;

    public StudentForMerge(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}

public class StudentTest3 {
    public static void main(String[] args) {
        StudentForMerge[] array1 = {
                new StudentForMerge("Alice", 3.9),
                new StudentForMerge("Bob", 3.5),
                new StudentForMerge("Charlie", 4.0)
        };

        StudentForMerge[] array2 = {
                new StudentForMerge("David", 3.7),
                new StudentForMerge("Eve", 3.8),
                new StudentForMerge("Frank", 3.6)
        };

        // Сортировка обоих массивов
        mergeSort(array1);
        mergeSort(array2);

        StudentForMerge[] mergedArray = merge(array1, array2);

        System.out.println("Объединенный и отсортированный массив студентов:");
        for (StudentForMerge student : mergedArray) {
            System.out.println(student);
        }
    }

    public static void mergeSort(StudentForMerge[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            StudentForMerge[] left = new StudentForMerge[mid];
            StudentForMerge[] right = new StudentForMerge[array.length - mid];

            System.arraycopy(array, 0, left, 0, mid);
            System.arraycopy(array, mid, right, 0, array.length - mid);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    public static void merge(StudentForMerge[] array, StudentForMerge[] left, StudentForMerge[] right) {
        int leftIndex = 0, rightIndex = 0, arrayIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].getGPA() >= right[rightIndex].getGPA()) {
                array[arrayIndex] = left[leftIndex];
                leftIndex++;
            } else {
                array[arrayIndex] = right[rightIndex];
                rightIndex++;
            }
            arrayIndex++;
        }

        while (leftIndex < left.length) {
            array[arrayIndex] = left[leftIndex];
            leftIndex++;
            arrayIndex++;
        }

        while (rightIndex < right.length) {
            array[arrayIndex] = right[rightIndex];
            rightIndex++;
            arrayIndex++;
        }
    }

    public static StudentForMerge[] merge(StudentForMerge[] left, StudentForMerge[] right) {
        StudentForMerge[] mergedArray = new StudentForMerge[left.length + right.length];
        int leftIndex = 0, rightIndex = 0, arrayIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].getGPA() >= right[rightIndex].getGPA()) {
                mergedArray[arrayIndex] = left[leftIndex];
                leftIndex++;
            } else {
                mergedArray[arrayIndex] = right[rightIndex];
                rightIndex++;
            }
            arrayIndex++;
        }

        while (leftIndex < left.length) {
            mergedArray[arrayIndex] = left[leftIndex];
            leftIndex++;
            arrayIndex++;
        }

        while (rightIndex < right.length) {
            mergedArray[arrayIndex] = right[rightIndex];
            rightIndex++;
            arrayIndex++;
        }

        return mergedArray;
    }
}
