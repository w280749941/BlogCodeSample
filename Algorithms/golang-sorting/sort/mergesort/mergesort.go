package mergesort


// Merge sort recursively split the array in half
// Until the array with only 1 element, it sorted.
// Then start to merge two arrays into one.
// So start with split array down then merge array up recursively.
// Time Complexity O(nlogn)
func MergeSorter(nums []int){
	mergeSort(nums, 0, len(nums)-1)
}

func mergeSort(nums []int, left int, right int) {

	if left >= right {
		return
	}

	mid := left + (right - left) / 2
	mergeSort(nums, left, mid)
	mergeSort(nums, mid+1, right)
	merge(nums, left, mid, right)
}
func merge(nums []int, left int, mid int, right int) {

	// Create two array(slice) to hold values to be merged
	sub1Len := mid - left + 1
	sub2Len := right - mid

	sub1 := make([]int, sub1Len)
	sub2 := make([]int, sub2Len)

	for i:=0; i<sub1Len; i++ {
		sub1[i] = nums[left + i]
	}
	// Since second array start at mid+1
	for i:=0; i<sub2Len; i++ {
		sub2[i] = nums[mid + 1 + i]
	}

	index := left
	i := 0
	j := 0

	// Merge values in asc order
	for i < sub1Len && j < sub2Len {
		if sub1[i] < sub2[j] {
			nums[index] = sub1[i]
			i++
			index++
		} else {
			nums[index] = sub2[j]
			j++
			index++
		}
	}

	// Merge the remaining values
	for i < sub1Len {
		nums[index] = sub1[i]
		i++
		index++
	}
	for j < sub2Len {
		nums[index] = sub2[j]
		j++
		index++
	}
}
