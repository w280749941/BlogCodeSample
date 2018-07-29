package main

import (
	"heartiger.com/algorithms/utility"
	"heartiger.com/algorithms/sort/quicksort"
	"heartiger.com/algorithms/sort/mergesort"
	"heartiger.com/algorithms/sort/heapsort"
	"heartiger.com/algorithms/sort/bubblesort"
	"heartiger.com/algorithms/sort/insertionsort"
	"heartiger.com/algorithms/sort/selectionsort"
	"log"
)

func main() {
	arraryStruct := utility.ArrayStruct{
		Size: 500000,
		Low: -100,
		High: 100,
	}
	log.Printf("Sorting arrays with size: %v, low: %v, high: %v", arraryStruct.Size, arraryStruct.Low, arraryStruct.High)
	utility.TestArrayPerformance(quicksort.QuickSorter, arraryStruct)
	utility.TestArrayPerformance(quicksort.QuickSorterOptimized, arraryStruct)
	utility.TestArrayPerformance(mergesort.MergeSorter, arraryStruct)
	utility.TestArrayPerformance(mergesort.MergeSorterOptimized, arraryStruct)
	utility.TestArrayPerformance(heapsort.HeapSorter, arraryStruct)
	utility.TestArrayPerformance(bubblesort.BubbleSort, arraryStruct)
	utility.TestArrayPerformance(bubblesort.BubbleSortOptimized, arraryStruct)
	utility.TestArrayPerformance(insertionsort.InsertionSort, arraryStruct)
	utility.TestArrayPerformance(selectionsort.SelectionSort, arraryStruct)
}

/*
func main() {
	arr := generateArray(15, 0, 100)
	fmt.Printf("Origin array: %v\n", arr)
	bubbleSort(arr)
	if isSorted(arr) {
		fmt.Printf("Bubble sort: %v\n\n", arr)
	} else {
		log.Printf("Bubble sort not sorted:\n %v\n\n", arr)
	}

	arr = generateArray(15, 0, 100)
	fmt.Printf("Origin array: %v\n", arr)
	selectionSort(arr)
	if isSorted(arr) {
		fmt.Printf("Selection sort: %v\n\n", arr)
	} else {
		fmt.Printf("Selection sort not sorted:\n %v\n\n", arr)
	}

	arr = generateArray(15, 0, 100)
	fmt.Printf("Origin array: %v\n", arr)
	insertionSort(arr)
	if isSorted(arr) {
		fmt.Printf("Insertion sort: %v\n\n", arr)
	} else {
		fmt.Printf("Insertion sort not sorted:\n %v\n\n", arr)
	}

	arr = generateArray(15, 0, 100)
	fmt.Printf("Origin array: %v\n", arr)
	quickSorter(arr)
	if isSorted(arr) {
		fmt.Printf("Quick sort: %v\n\n", arr)
	} else {
		fmt.Printf("Quick sort not sorted:\n %v\n\n", arr)
	}

	arr = generateArray(15, 0, 100)
	fmt.Printf("Origin array: %v\n", arr)
	heapSort(arr)
	if isSorted(arr) {
		fmt.Printf("Heap sort: %v\n\n", arr)
	} else {
		fmt.Printf("Heap sort not sorted:\n %v\n\n", arr)
	}

	arr = generateArray(15, 0, 100)
	fmt.Printf("Origin array: %v\n", arr)
	mergeSorter(arr)
	if isSorted(arr) {
		fmt.Printf("Merge sort: %v\n\n", arr)
	} else {
		fmt.Printf("Merge sort not sorted:\n %v\n\n", arr)
	}
}

func mergeSorter(arr []int) {
	mergeSort(arr, 0, len(arr) - 1)
}
func mergeSort(arr []int, left int, right int) {

	if left >= right {
		return
	}
	mid := left + (right - left) / 2
	mergeSort(arr, left, mid)
	mergeSort(arr, mid+1, right)
	if arr[mid] > arr[mid+1]{
		Merge(arr, left, mid, right)
	}

}

func Merge(arr []int, left int, mid int, right int) {
	sub1Len := mid - left + 1
	sub2Len := right - mid

	sub1 := make([]int, sub1Len)
	sub2 := make([]int, sub2Len)

	for i:=0; i<sub1Len; i++ {
		sub1[i] = arr[i + left]
	}

	for i:=0; i<sub2Len; i++ {
		sub2[i] = arr[i + mid + 1]
	}

	i := 0
	j := 0
	index :=left
	for i < sub1Len && j < sub2Len {
		if sub1[i] < sub2[j] {
			arr[index] = sub1[i]
			index++
			i++
		} else {
			arr[index] = sub2[j]
			index++
			j++
		}
	}

	for i < sub1Len {
		arr[index] = sub1[i]
		index++
		i++
	}

	for j < sub2Len {
		arr[index] = sub2[j]
		index++
		j++
	}
}

func heapSort(arr []int) {

	for i := len(arr)/2 -1; i>=0; i-- {
		heapify(arr, len(arr), i)
	}

	for i := len(arr)-1; i>=0; i-- {
		swap(arr, i, 0)
		heapify(arr, i, 0)
	}
}

func heapify(arr []int, size int, root int) {
	largestIndex := root
	left := root * 2 + 1
	right := root * 2 + 2
	if left < size && arr[left] > arr[largestIndex] {
		largestIndex = left
	}
	if right < size && arr[right] > arr[largestIndex] {
		largestIndex = right
	}
	if largestIndex == root {
		return
	}

	swap(arr, largestIndex, root)
	heapify(arr, size, largestIndex)
}

func quickSorter(arr []int) {
	quickSort(arr, 0, len(arr))
}
func quickSort(arr []int, left int, right int) {
	if left >= right {
		return
	}

	index := partition(arr, left, right)
	quickSort(arr, left, index)
	quickSort(arr, index+1, right)
}

func partition(arr []int, left int, right int) int {
	pivot := arr[right-1]
	j := left
	for i := left; i<right-1; i++ {
		if arr[i] > pivot {
			continue
		}

		swap(arr, j, i)
		j++
	}
	swap(arr, j, right-1)
	return j
}

func insertionSort(arr []int) {
	for i :=1; i < len(arr); i++ {
		j := i-1
		temp := arr[i]
		for j >=0 && arr[j] > temp {
			arr[j+1] = arr[j]
			j--
		}
		arr[j+1] = temp
	}
}
func selectionSort(arr []int) {
	for i := 0; i < len(arr); i++ {
		minIndex := i
		for j := i+1; j < len(arr); j++ {
			if arr[j] < arr[minIndex]{
				minIndex = j
			}
		}
		if minIndex != i {
			swap(arr, minIndex, i)
		}
	}
}

func bubbleSort(arr []int) {
	for i := len(arr); i>=0; i-- {
		for j := 1; j < i; j++ {
			if arr[j-1] > arr[j] {
				swap(arr, j-1, j)
			}
		}
	}
}

func swap(arr []int, i int, j int) {
	temp := arr[i]
	arr[i] = arr[j]
	arr[j] = temp
}

func generateArray(size, low, high int) []int{
	out := make([]int, size)

	for i := range out {
		out[i] = getRandomNum(low, high)
	}

	return out
}

func getRandomNum(low int, high int) int {
	return rand.Intn(high-low) + low
}

func isSorted(arr []int) bool {
	for i:=1; i<len(arr); i++ {
		if arr[i-1] > arr[i] {
			return false
		}
	}
	return true
}

/*
func mergeSorter(arr []int) {
	mergeSort(arr, 0, len(arr) - 1)
}

func mergeSort(arr []int, left int, right int) {
	if left >= right {
		return
	}
	mid := left + (right - left) / 2
	mergeSort(arr, left, mid)
	mergeSort(arr, mid+1, right)
	if arr[mid] > arr[mid+1] {
		merge(arr, left, mid, right)
	}
}

func merge(arr []int, left int, mid int, right int) {
	sub1Len := mid - left + 1
	sub2Len := right - mid

	sub1 := make([]int, sub1Len)
	sub2 := make([]int, sub2Len)

	for i := 0; i < sub1Len; i++ {
		sub1[i] = arr[i + left]
	}
	for i := 0; i < sub2Len; i++ {
		sub2[i] = arr[i + mid + 1]
	}

	index := left
	j := 0
	i := 0
	for i < sub1Len && j < sub2Len {
		if sub1[i] < sub2[j] {
			arr[index] = sub1[i]
			index++
			i++
		} else {
			arr[index] = sub2[j]
			index++
			j++
		}
	}

	for i < sub1Len {
		arr[index] = sub1[i]
		index++
		i++
	}
	for j < sub2Len {
		arr[index] = sub2[j]
		index++
		j++
	}
}


func heapSort(arr []int) {
	for i := len(arr)/2 -1; i>=0; i-- {
		headily(arr, len(arr), i)
	}

	for i := len(arr)-1; i>=0; i-- {
		swap(arr, 0, i)
		headily(arr, i, 0)
	}
}

func headily(arr []int, size int, root int) {
	largestIndex := root
	left := root * 2 + 1
	right := root * 2 + 2

	if left < size && arr[left] > arr[largestIndex]{
		largestIndex = left
	}
	if right < size && arr[right] > arr[largestIndex]{
		largestIndex = right
	}

	if largestIndex == root {
		return
	}

	swap(arr, largestIndex, root)
	headily(arr, size, largestIndex)
}

func quickSorter(arr []int) {
	quickSort(arr, 0, len(arr))
}

func quickSort(arr []int, left int, right int) {
	if left >= right{
		return
	}

	index := partition(arr, left, right)
	quickSort(arr, left, index)
	quickSort(arr, index+1, right)
}

func partition(arr []int, left int, right int) int {
	pivot := arr[right-1]
	j := left

	for i := left; i < right-1; i++ {
		if arr[i] > pivot {
			continue
		}

		swap(arr, i, j)
		j++
	}
	swap(arr, j, right-1)
	return j
}

func insertionSort(arr []int) {
	for i := 1; i < len(arr); i++ {
		j := i-1
		temp := arr[i]
		for j >= 0 && arr[j] > temp {
			arr[j+1] = arr[j]
			j--
		}
		arr[j+1] = temp
	}
}

func selectionSort(arr []int) {
	for i := 0; i < len(arr); i++ {
		min := i
		for j := i+1; j < len(arr); j++ {
			if arr[j] < arr[min]{
				min = j
			}
		}
		if min != i {
			swap(arr, min, i)
		}
	}
}

func bubbleSort(arr []int) {
	for n := len(arr); n >= 0; n-- {
		for i := 1; i < n; i++ {
			if arr[i-1] > arr[i] {
				swap(arr, i, i-1)
			}
		}
	}
}

*/
