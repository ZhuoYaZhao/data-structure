/* eslint-disable */
function LinkedList () {
  class Node {
    constructor (element) {
      this.element = element
      this.next = null
    }
  }
  let length = 0
  let head = null
  // 向列表尾部添加一个新的项
  this.append = function (element) {
    // eslint-disable-next-line no-use-before-define
    let node = new Node(element)
    let current
    if (head === null) {
      head = node
    } else {
      current = head
      while (current.next) {
        current = current.next
      }
      current.next = node
    }
    length++
  }
  // 向列表特定位置插入一个新的项,不包括在最后一位添加元素
  this.insert = function (element, position) {
    let node =new Node(element)
    let current=head,previous,index=0
    if (position > -1 && position < length) {
      if(position===0){
        node.next=current
        head=node
      }else{
        while(index++<position){
          previous=current
          current=current.next
        }
        node.next=current
        previous.next=node
      }
      length++
      return true
    }else{
      return false
    }
  }
  // 从列表中移除一项
  this.remove = function (element) {
    let index=this.indexOf(element)
    return this.removeAt(index)
  }
  // 返回元素在列表中的索引，如果没有该元素则返回-1
  this.indexOf = function (element) {
    let current=head,index=0
    while(current){
      if(current.element===element){
        return index
      }
      index++
      current=current.next
    }
    return -1
  }
  // 从列表中的特定元素位置移除一项,返回移除的元素
  this.removeAt = function (position) {
    let current=head,previous,index=0
    if (position > -1 && position < length) {
      if(position===0){
        head=current.next
      }else{
        while(index++<position){
          previous=current
          current=current.next
          //相当于这里写++，执行完再加
        }
        previous.next=current.next
      }
      length--
      return current.element
    }else{
      return null
    }
   
  }
  // 判断是否为空链表,返回true,false
  this.isEmpty = function () {
    let node = new Node()
    // eslint-disable-next-line no-unneeded-ternary
    return length === 0
  }
  // 返回链表包括的元素个数
  this.size = function () {
    return length
  }
  // 继承JavaScript默认对象toString方法，输出元素的值
  this.toString = function () {
    let current = head
    let string = ''
    while (current) {
      string += current.element + (current.next ? ',' : '')
      current = current.next
    }
    return string
  }
  this.getHead=function(){
    return head.element
  }
}
export default LinkedList
