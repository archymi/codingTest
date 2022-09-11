# https://school.programmers.co.kr/learn/courses/30/lessons/118667?language=python3

def solution(queue1, queue2):
    queue = queue1 + queue2
    answer_index = []
    answer_list = []
    for i in range(0, len(queue)):
        newQueue = queue[i:] + queue[:i]
        for j in range(0, len(newQueue)):
            if sum(newQueue[:j]) == sum(newQueue[j:]):
                print(i, j, newQueue[:j], newQueue[j:])
                print(i * 2 + len(newQueue[:j]) - len(queue1))
                print(i * 2 + len(queue1) - len(newQueue[:j]))
                answer_list.append(i * 2 + len(newQueue[:j]) - len(queue1))
                answer_list.append(i * 2 + len(newQueue[:j]) - len(queue1))
                answer_index.append([i, j])

    print(answer_index)
    for [a, b] in answer_index:
        print(queue[a:],  queue[:a])

    if len(answer_index) == 0:
        return -1

    return min(answer_list)

# print(solution([3, 2, 7, 2], [4, 6, 5, 1])); # 2
print(solution([1, 2, 1, 2], [1, 10, 1, 2])); # 2
# print(solution([1, 1], [1, 5])); # 2