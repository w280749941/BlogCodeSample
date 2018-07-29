package heapsort

import "heartiger.com/algorithms/utility"

// Heap sort first build a max heap.
// Then it extract the largest element from the root
// Place it at the end of the array and call heapify
// To get another largest element.
// Complexity is O(nlogn)
// Max-heapify takes O(logn)
// There are O(n) calls to heapify.
func HeapSorter(nums []int) {
	heapSort(nums, 0, len(nums))
}

func heapSort(nums []int, left int, right int) {
	for i := (right-1)/2; i >= 0; i-- {
		heapify(nums, len(nums), i)
	}

	for i := right-1; i >=0; i-- {
		utility.Swap(nums, i, 0)
		heapify(nums, i, 0)
	}
}

// left is left child, right is right child index in the array.
func heapify(nums []int, size int, root int) {
	largestIndex := root
	left := 2 * root + 1
	right := 2 * root + 2

	if left < size && nums[left] > nums[largestIndex] {
		largestIndex = left
	}
	if right < size && nums[right] > nums[largestIndex] {
		largestIndex = right
	}

	if largestIndex != root {
		utility.Swap(nums, largestIndex, root)
		heapify(nums, size, largestIndex)
	}
}
