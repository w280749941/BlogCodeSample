package quicksort

import (
	"heartiger.com/algorithms/utility"
	"heartiger.com/algorithms/sort/insertionsort"
)

func QuickSorterOptimized(nums []int) {
	quickSortOptimized(nums, 0, len(nums))
}
func quickSortOptimized(nums []int, left int, right int) {

	// (Optimization): Use insertion sort when size lesser than 15
	if right-left <= 15 {
		insertionsort.InsertionSortWithIndexes(nums, left, right)
		return
	}

	partitionIndex := partitionOptimized(nums, left, right)
	quickSortOptimized(nums, left, partitionIndex)
	quickSortOptimized(nums, partitionIndex+1, right)
}
func partitionOptimized(nums []int, left int, right int) int {
	// (Optimization): Use a random number from the array as a pivot.
	// This can better reduces the extreme situation as partition size difference.
	utility.Swap(nums, right-1, utility.GetRandomNum(left, right))
	pivot := nums[right-1]


	// (Optimization): reduce partition size difference caused by same element value
	// l scan from left side to find element greater than pivot.
	// r scan from right side to find element greater than pivot.
	// Than they swap.
	// If there exist many same value element, there could exist biased partition size.
	// Because previously we separate element with > and <=.
	// "<=" this causes two types elements go to one sie, and ">" elements to go the side.
	l := left
	r := right-2
	for {
		for l <= right-2 && nums[l] < pivot {
			l++
		}
		for r >= left && nums[r] > pivot {
			r--
		}
		if l > r {
			break
		}
		utility.Swap(nums, l, r)
		l++
		r--
	}
	r++
	utility.Swap(nums, right-1, r)
	return r
}
