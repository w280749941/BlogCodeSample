package insertionsort

// Insertion sort is similar to how people sort their poker.
// Find a smaller one insert it at left part and shift
// Larger elements to the right side.
// Here used shift elements instead of Swap elements
// Which is more efficient than swap.
// Complexity is O(n2)
// If the array is sorted, it's O(n)
func InsertionSort(nums []int) {
	for i := 1; i < len(nums); i++ {
		j := i-1
		temp := nums[i]
		for j >=0 && nums[j] > temp {
			nums[j+1] = nums[j]
			j--
		}
		nums[j+1] = temp
	}
}

func InsertionSortWithIndexes(nums []int, left, right int) {
	for i := left+1; i < right; i++ {
		j := i-1
		temp := nums[i]
		for j >=0 && nums[j] > temp {
			nums[j+1] = nums[j]
			j--
		}
		nums[j+1] = temp
	}
}