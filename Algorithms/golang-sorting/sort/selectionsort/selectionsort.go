package selectionsort

import "heartiger.com/algorithms/utility"

// In every outer loop we assume current element is the smallest
// among elements after it. If we found any element that's smaller than
// it, update the smallest index. Finally swap the smallest element to the front.
// Complexity is O(n2)
func SelectionSort(nums []int) {
	for i := 0; i < len(nums); i++ {
		minIndex := i
		for j := i+1; j < len(nums); j++ {
			if nums[j] < nums[minIndex] {
				minIndex = j
			}
		}
		if minIndex != i {
			utility.Swap(nums, minIndex, i)
		}
	}
}
