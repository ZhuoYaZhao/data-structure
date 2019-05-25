import Baseball from '../../code/stack/stack'
test('Bassball', () => {
  expect(Baseball(['5', '2', 'C', 'D', '+'])).toBe(30)
})
