import MyCircularQueue from '../../code/queue/queue'
test('MyCircularQueue', () => {
  let queue = new MyCircularQueue(4)
  queue.enQueue(2)
  queue.enQueue(3)
  queue.enQueue(4)
  expect(queue.isFull()).toBe(false)
  expect(queue.deQueue()).toBe(2)
  expect(queue.isEmpty()).toBe(false)
  expect(queue.Rear()).toBe(4)
  expect(queue.Front()).toBe(3)
})
