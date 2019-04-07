// 本题为682棒球比赛
export default (arr) => {
  // Pre1获取前一个数据
  // pre2获取再前一个数据
  let pre1
  let pre2
  let result = []
  arr.forEach(item => {
    switch (item) {
      case 'C':
        if (result.length) {
          return result.pop()
        }
      // eslint-disable-next-line no-fallthrough
      case 'D':
        pre1 = result.pop()
        return result.push(pre1, pre1 * 2)
      case '+':
        pre1 = result.pop()
        pre2 = result.pop()
        return result.push(pre2, pre1, pre1 + pre2)
      default:
        return result.push(item * 1)
    }
  })
  // eslint-disable-next-line no-unused-expressions
  return result.reduce((total, num) => { return total + num })
}
