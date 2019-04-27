import LinkedList from '../../code/linkedlist/linkedlist'

test('test linkedlist', () => {
  let list = new LinkedList()
  list.append(15)
  list.append(16)
  list.append(17)
  list.append(18)
  list.append(19)
  list.removeAt(4)
  expect(list.indexOf(16)).toEqual(1)
  expect(list.toString()).toEqual('15,16,17,18')
  expect(list.getHead()).toEqual(15)
  list.remove(15)
  expect(list.insert(20, 2)).toEqual(true)
  expect(list.toString()).toEqual('16,17,20,18')
})
