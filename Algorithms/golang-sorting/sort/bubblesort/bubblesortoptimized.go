package bubblesort

import "heartiger.com/algorithms/utility"

// Added a boolean flag to check whether there
// is a swap happen in each iteration.
// As soon as there is no swap in a iteration,
// Array is sorted.
// Complexity is still O(n2)
// If the array is sorted, it's O(n)
func BubbleSortOptimized(nums []int) {
	for n := len(nums); n > 1; n-- {
		swapped := false
		for i := 1; i < n; i++ {
			if nums[i-1] > nums[i] {
				swapped = true
				utility.Swap(nums, i-1, i)
			}
		}
		if !swapped {
			return
		}
	}
}