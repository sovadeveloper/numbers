# Тестовое задание (РЕЛЭКС)

## Примеры REST-запросов

Для поулчения json/xml ответа необходимо добавить соответсвенные headers - Accept: application/json или Accpet: application/xml

- Загрузка файла [POST]
 
  Request: "api/numbers/upload"
  
  Response: {file: file(select)}
  
- Получение максимального числа [GET]:

  Request: "api/numbers/get_max_value"
  
  Response: {value: n}
  
- Получение минимального числа [GET]

  Request: "api/numbers/get_min_value"
  
  Response: {value: n}
  
- Получение медианы [GET]

  Request: "api/numbers/get_median"
  
  Response: {value: n}
  
- Получение среднего арифметического [GET]

  Request: "api/numbers/get_average"
  
  Response: {value: n}
  
- Получение возрастающей последовтельности [GET]

  Request: "api/numbers/get_increasing_sequence"
  
  Response: {value: [n1, n2, n3, n4, n5]}
  
- Получение убывающей последовтельности [GET]

  Request: "api/numbers/get_decreasing_sequence"
  
  Response: {value: [n1, n2, n3, n4, n5]}
  
## Полученные данные

Максимальное значение: 49999978

Минималььное значение: -49999996

Медиана: 25216

Среднее арифметическое: 7364.418442641844

Возрастающая последовательность: -48190694, -47725447, -43038241, -20190291, -17190728, -6172572, 8475960, 25205909, 48332507, 48676185

Убывающая последовательность: 47689379, 42381213, 30043880, 12102356, -4774057, -5157723, -11217378, -23005285, -23016933, -39209115, -49148762
