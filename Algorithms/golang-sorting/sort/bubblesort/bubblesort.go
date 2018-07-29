package bubblesort

import "heartiger.com/algorithms/utility"

// Start from beginning of the array
// Move larger item to the right and loop.
// Complexity O(n2)
func BubbleSort(nums []int) {
	for n := len(nums); n > 1; n-- {
		for i := 1; i < n; i++ {
			if nums[i-1] > nums[i] {
				utility.Swap(nums, i-1, i)
			}
		}
	}
}
