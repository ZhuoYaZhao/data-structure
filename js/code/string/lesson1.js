// export default (str) => {
//   let arr = str.split(' ')
//   let result = arr.map(item => {
//     return item.split('').reverse().join('')
//   })
//   return result.join(' ')
// }
export default (str) => {
  // 1.字符串按空格进行分隔，保存数组
  // 2.对数组进行遍历，进行反序操作，
  return str.split(' ').map(item => {
    return item.split('').reverse().join('')
  }).join(' ')
}
