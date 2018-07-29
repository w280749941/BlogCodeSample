package quicksort

import "heartiger.com/algorithms/utility"


// Quicksort set a pivot from the array
// Put all elements <= pivot to the left
// And elements > pivot to the right of the pivot.
// Then sort left hand side and right hand side until left=right.
// Time Complexity O(nlogn)
func QuickSorter(nums []int) {
	quickSort(nums, 0, len(nums))
}
func quickSort(nums []int, left int, right int) {

	if left >= right {
		return
	}

	partitionIndex := partition(nums, left, right)
	quickSort(nums, left, partitionIndex)
	quickSort(nums, partitionIndex+1, right)
}
func partition(nums []int, left int, right int) int {
	pivot := nums[right-1]

	largerItemIndex := left
	for i := left; i < right-1; i++ {
		if nums[i] > pivot {
			continue
		}
		utility.Swap(nums, largerItemIndex, i)
		largerItemIndex++
	}
	utility.Swap(nums, largerItemIndex, right-1)
	return largerItemIndex
}
