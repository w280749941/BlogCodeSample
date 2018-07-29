package utility

import (
	"math/rand"
	"time"
	"log"
	"reflect"
	"runtime"
	"strings"
)

type ArrayStruct struct {
	Size int
	Low  int
	High int
}

func Swap(nums []int, a, b int) {
	temp := nums[a]
	nums[a] = nums[b]
	nums[b] = temp
}

func GenerateArray(size, low, high int) []int{
	out := make([]int, size)

	for i := range out {
		out[i] = GetRandomNum(low, high)
	}

	return out
}

func GenerateSortedArray(size int) []int{
	out := make([]int, size)

	for i := range out {
		out[i] = i
	}

	return out
}

func GenerateReversedArray(size int) []int{
	out := make([]int, size)

	for i := range out {
		out[i] = size-i
	}

	return out
}

func GetRandomNum(low int, high int) int {
	return rand.Intn(high-low) + low
}

func IsSorted(arr []int) bool {
	for i:=1; i<len(arr); i++ {
		if arr[i-1] > arr[i] {
			return false
		}
	}
	return true
}

func TestArrayPerformance(sorter func([]int), arrayStruct ArrayStruct) {
	randomArray := GenerateArray(arrayStruct.Size, arrayStruct.Low, arrayStruct.High)
	sortedArray := GenerateSortedArray(arrayStruct.Size)
	reversedArray := GenerateReversedArray(arrayStruct.Size)

	sortArray(sorter, randomArray, "Random Array")
	sortArray(sorter, sortedArray, "Sorted Array")
	sortArray(sorter, reversedArray, "Reversed Array")
}

func sortArray(sorter func([]int), nums []int, arrayType string){
	funcFullName := runtime.FuncForPC(reflect.ValueOf(sorter).Pointer()).Name()
	nameSlice := strings.Split(funcFullName, ".")
	funcName := nameSlice[len(nameSlice)-1]
	start := time.Now()
	sorter(nums)
	elapsed := time.Since(start)
	if IsSorted(nums){
		log.Printf("%s sort %s spent %vs", funcName,
			arrayType, elapsed.Seconds())
	} else {
		log.Printf("%s Failed", funcName)
	}
}