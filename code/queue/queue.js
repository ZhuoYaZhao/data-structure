// 本题为622设计循环队列
export default class MyCircularQueue {
  constructor (k) {
    // 用来保存数据长度为K的数据结构
    this.list = Array(k)
    // 队首指针
    this.front = 0
    // 队尾指针
    this.rear = 0
    // 队列长度
    this.max = k
  }
  // 判断队列是否满
  isFull () {
    return this.front === this.rear && this.list[this.front]
  }
  // 判断是否空队列
  isEmpty () {
    return this.front === this.rear && !this.list[this.front]
  }
  // 首元素
  Front () {
    return this.list[this.front]
  }
  // 尾元素
  Rear () {
    return this.list[ this.rear === 0 ? this.max : this.rear - 1 ]
  }
  // 增加元素
  enQueue (num) {
    if (this.isFull()) {
      return false
    }
    this.list[this.rear] = num
    this.rear = (this.rear + 1) % this.max
    return true
  }
  // 移出元素
  deQueue () {
    if (this.isEmpty()) {
      return false
    }
    let v = this.list[this.front]
    this.list[this.front] = ''
    this.front = (this.front + 1) % this.max
    return v
  }
}
