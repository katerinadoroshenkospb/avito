# Тест-кейсы для проверки API микросервиса хранения данных по объявлениям

# Тест-сьют "Создать объявления: POST /api/1/item"

## Тест-кейс 1: Успешное создание 200 OK
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 886648,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 200 ОК, ошибок в структуре ответа нет, объявление создано
{
  "id": "<string>",
  "sellerId": "<integer>",
  "name": "<string>",
  "price": "<integer>",
  "statistics": {
    "likes": "<integer>",
    "viewCount": "<integer>",
    "contacts": "<integer>"
  },
  "createdAt": "<string>"
}

## Тест-кейс 2: Неуспешное создание 400 Bad Request при передаче в sellerID 5 целых чисел
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 46517,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 3: Неуспешное создание 400 Bad Request при передаче в sellerID нуля
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 000000,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 4: Неуспешное создание 400 Bad Request при передаче в sellerID пустого значения null
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": null,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 5: Неуспешное создание 400 Bad Request при передаче в sellerID логического значения true
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": true,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 6: Неуспешное создание 400 Bad Request при передаче в sellerID отрицательного числа
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": -64146,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 7: Неуспешное создание 400 Bad Request при передаче в sellerID дробного числа
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 50,435,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 8: Неуспешное создание 400 Bad Request при передаче sellerID в формате строки
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": "seller",
  "name": 25,
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 9: Неуспешное создание 400 Bad Request при передаче в name символов !"№;%
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 688598,
  "name": !"№;%,
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 10: Неуспешное создание 400 Bad Request при передаче в name очень длинного значения
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 283177,
  "name": "obyavlenieobyavlenieobyavlenieobyavlenieobyavlenieobyavlenieobyavlenieobyavlenieobyavlenieobyavlenieobyavlenieobyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 11: Неуспешное создание 400 Bad Request при передаче в name пустого значения null
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 855749,
  "name": null,
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 12: Неуспешное создание 400 Bad Request при передаче в name логического значения true
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 567954,
  "name": true,
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 13: Неуспешное создание 400 Bad Request при передаче name в формате цифр
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 771346,
  "name": 25,
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 14: Неуспешное создание 400 Bad Request при передаче в price нуля
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 369293,
  "name": "obyavlenie",
  "price": 0,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 15: Неуспешное создание 400 Bad Request при передаче в price значения больше int
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 277602,
  "name": "obyavlenie",
  "price": 2147483648,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 16: Неуспешное создание 400 Bad Request при передаче в price пустого значения null
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 442852,
  "name": "obyavlenie",
  "price": null,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 17: Неуспешное создание 400 Bad Request при передаче в price логического значения true
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 197493,
  "name": "obyavlenie",
  "price": true,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 18: Неуспешное создание 400 Bad Request при передаче в price отрицательного числа
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 967139,
  "name": "obyavlenie",
  "price": -25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 19: Неуспешное создание 400 Bad Request при передаче в price дробного числа
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 559068,
  "name": "obyavlenie",
  "price": 2,5,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 20: Неуспешное создание 400 Bad Request при передаче price в формате строки
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 916108,
  "name": 25,
  "price": "price",
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 21: Неуспешное создание 400 Bad Request при передаче в likes нуля
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 633256,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 0,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 22: Неуспешное создание 400 Bad Request при передаче в likes значения больше int
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 835510,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 2147483648,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 23: Неуспешное создание 400 Bad Request при передаче в likes пустого значения null
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 326927,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": null,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 24: Неуспешное создание 400 Bad Request при передаче в likes логического значения true
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 571390,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": true,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 25: Неуспешное создание 400 Bad Request при передаче в likes отрицательного числа
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 264918,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": -25,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 26: Неуспешное создание 400 Bad Request при передаче в likes дробного числа
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 234563,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 2,5,
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 27: Неуспешное создание 400 Bad Request при передаче likes в формате строки
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 318790,
  "name": 25,
  "price": 25,
  "statistics": {
    "likes": "likes",
    "viewCount": 25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 28: Неуспешное создание 400 Bad Request при передаче в viewCount нуля
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 892337,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 0,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 29: Неуспешное создание 400 Bad Request при передаче в viewCount значения больше int
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 362988,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 2147483648,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 30: Неуспешное создание 400 Bad Request при передаче в viewCount пустого значения null
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 815577,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": null,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 31: Неуспешное создание 400 Bad Request при передаче в viewCount логического значения true
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 482486,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": true,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 32: Неуспешное создание 400 Bad Request при передаче в viewCount отрицательного числа
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 651658,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": -25,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 33: Неуспешное создание 400 Bad Request при передаче в viewCount дробного числа
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 677137,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 2,5,
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 34: Неуспешное создание 400 Bad Request при передаче viewCount в формате строки
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 558707,
  "name": 25,
  "price": 25,
  "statistics": {
    "likes": "likes",
    "viewCount": "view",
    "contacts": 25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 35: Неуспешное создание 400 Bad Request при передаче в contacts нуля
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 112232,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 0
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 36: Неуспешное создание 400 Bad Request при передаче в contacts пустого значения null
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 321558,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": null
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 37: Неуспешное создание 400 Bad Request при передаче в contacts логического значения true
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 395522,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": true
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 38: Неуспешное создание 400 Bad Request при передаче в contacts отрицательного числа
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 837195,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": -25
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 39: Неуспешное создание 400 Bad Request при передаче в contacts дробного числа
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 830064,
  "name": "obyavlenie",
  "price": 25,
  "statistics": {
    "likes": 25,
    "viewCount": 25,
    "contacts": 2,5
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

## Тест-кейс 40: Неуспешное создание 400 Bad Request при передаче contacts в формате строки
### Шаги: Отправить запрос
curl --location --request POST 'https://qa-internship.avito.com/api/1/item' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
  "sellerID": 558707,
  "name": 25,
  "price": 25,
  "statistics": {
    "likes": "likes",
    "viewCount": "view",
    "contacts": "contacts"
  }
}'
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не создано
{
    "result": {
        "message": "передан некорректный идентификатор объявления",
        "messages": null
    },
    "status": "400"
}

# Тест-сьют "Получить объявления по его идентификатору: GET /api/1/item/:id"

## Тест-кейс 1: Успешное получение 200 OK
### Шаги: Создать запрос с id 5a57bf44-4ca7-4ade-8d25-782461432e37 и Description "obyavlenie"
### Ожидаемый результат: Код и статус ответа 200 ОК, ошибок в структуре ответа нет, объявление получено
[
    {
        "createdAt": "2025-12-26 14:20:34.969808 +0300 +0300",
        "id": "5a57bf44-4ca7-4ade-8d25-782461432e37",
        "name": "obyavlenie",
        "price": 25,
        "sellerId": 849725,
        "statistics": {
            "contacts": 25,
            "likes": 25,
            "viewCount": 25
        }
    }
]

## Тест-кейс 2: Неуспешное получение 400 Bad Request при передаче id в формате числа
### Шаги: Создать запрос с id 5 и Description "obyavlenie"
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
    "result": {
        "message": "ID айтема не UUID: 5",
        "messages": {}
    },
    "status": "400"
}

## Тест-кейс 3: Неуспешное получение 400 Bad Request при передаче в id нуля
### Шаги: Создать запрос с id 00000000-0000-0000-0000-000 и Description "obyavlenie"
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
    "result": {
        "message": "ID айтема не UUID: 5",
        "messages": {}
    },
    "status": "400"
}

## Тест-кейс 4: Неуспешное получение 400 Bad Request при непередаче id
### Шаги: Создать запрос без id и Description "obyavlenie"
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
    "result": {
        "message": "ID айтема не UUID: 5",
        "messages": {}
    },
    "status": "400"
}

## Тест-кейс 5: Неуспешное получение 400 Bad Request при передаче в id пустого значения null
### Шаги: Создать запрос с id null и Description "obyavlenie"
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
    "result": {
        "message": "ID айтема не UUID: 5",
        "messages": {}
    },
    "status": "400"
}

## Тест-кейс 6: Неуспешное получение 400 Bad Request при непередаче Description
### Шаги: Создать запрос с id 5a57bf44-4ca7-4ade-8d25-782461432e37 и без Description
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено

## Тест-кейс 7: Неуспешное получение 400 Bad Request при передаче в Description пустого значения null
### Шаги: Создать запрос с id 5a57bf44-4ca7-4ade-8d25-782461432e37 и Description null
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено

## Тест-кейс 8: Неуспешное получение 404 Not Found при передаче несуществующего id
### Шаги: Создать запрос с id 6a57bf44-4ca7-4ade-8d25-782461432e37 и Description "obyavlenie"
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
  "result": "laborum",
  "status": "cillum enim eiusmod"
}

## Тест-кейс 9: Неуспешное получение 404 Not Found при передаче несуществующего Description
### Шаги: Создать запрос с id 5a57bf44-4ca7-4ade-8d25-782461432e37 и Description 5a57bf44-4ca7-4ade-8d25-782461432e37
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
  "result": "laborum",
  "status": "cillum enim eiusmod"
}

# Тест-сьют "Получить все объявления по идентификатору продавца: GET /api/1/:sellerID/item"

## Тест-кейс 1: Успешное получение 200 ОК
### Шаги: Создать запрос с sellerID 886648 и Description 886648
### Ожидаемый результат: Код и статус ответа 200 ОК, ошибок в структуре ответа нет, объявление получено
[
  {
    "id": "<string>",
    "sellerId": "<integer>",
    "name": "<string>",
    "price": "<integer>",
    "statistics": {
      "likes": "<integer>",
      "viewCount": "<integer>",
      "contacts": "<integer>"
    },
    "createdAt": "<string>"
  },
  {
    "id": "<string>",
    "sellerId": "<integer>",
    "name": "<string>",
    "price": "<integer>",
    "statistics": {
      "likes": "<integer>",
      "viewCount": "<integer>",
      "contacts": "<integer>"
    },
    "createdAt": "<string>"
  }
]

## Тест-кейс 2: Неуспешное получение 400 Bad Request при передаче id в формате строки
### Шаги: Создать запрос с id "886648" и Description 886648
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
    "result": {
        "message": "передан некорректный идентификатор продавца",
        "messages": {}
    },
    "status": "400"
}

## Тест-кейс 3: Неуспешное получение 400 Bad Request при передаче в id нуля
### Шаги: Создать запрос с id 000000 и Description 886648
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
    "result": {
        "message": "передан некорректный идентификатор продавца",
        "messages": {}
    },
    "status": "400"
}

## Тест-кейс 4: Неуспешное получение 400 Bad Request при непередаче id
### Шаги: Создать запрос без id и Description 886648
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
    "result": {
        "message": "передан некорректный идентификатор продавца",
        "messages": {}
    },
    "status": "400"
}

## Тест-кейс 5: Неуспешное получение 400 Bad Request при передаче в id пустого значения null
### Шаги: Создать запрос с id null и Description 886648
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
    "result": {
        "message": "передан некорректный идентификатор продавца",
        "messages": {}
    },
    "status": "400"
}

## Тест-кейс 6: Неуспешное получение 400 Bad Request при непередаче Description
### Шаги: Создать запрос с id 886648 и без Description
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено

## Тест-кейс 7: Неуспешное получение 400 Bad Request при передаче в Description пустого значения null
### Шаги: Создать запрос с id 886648 и Description null
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено

## Тест-кейс 8: Неуспешное получение 400 Bad Request при передаче несуществующего id
### Шаги: Создать запрос с id 111110 и Description 886648
### Ожидаемый результат: Код и статус ответа 404 Not Found, объявление не получено


## Тест-кейс 9: Неуспешное получение 404 Not Found при передаче несуществующего Description
### Шаги: Создать запрос с id 886648 и Description 111110
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
  "result": "laborum",
  "status": "cillum enim eiusmod"
}

# Тест-сьют "Получить статистику по айтем GET /api/1/statistic/:id"

## Тест-кейс 1: Успешное получение 200 OK
### Шаги: Создать запрос с id 5a57bf44-4ca7-4ade-8d25-782461432e37 и Description "obyavlenie"
### Ожидаемый результат: Код и статус ответа 200 ОК, ошибок в структуре ответа нет, объявление получено
[
  {
    "likes": "<integer>",
    "viewCount": "<integer>",
    "contacts": "<integer>"
  },
  {
    "likes": "<integer>",
    "viewCount": "<integer>",
    "contacts": "<integer>"
  }
]
## Тест-кейс 2: Неуспешное получение 404 Not Found при передаче id в формате числа
### Шаги: Создать запрос с id 5 и Description "obyavlenie"
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
  "result": "laborum",
  "status": "cillum enim eiusmod"
}

## Тест-кейс 3: Неуспешное получение 4404 Not Found при передаче в id нуля
### Шаги: Создать запрос с id 00000000-0000-0000-0000-000 и Description "obyavlenie"
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
  "result": "laborum",
  "status": "cillum enim eiusmod"
}

## Тест-кейс 4: Неуспешное получение 404 Not Found при непередаче id
### Шаги: Создать запрос без id и Description "obyavlenie"
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
  "result": "laborum",
  "status": "cillum enim eiusmod"
}

## Тест-кейс 5: Неуспешное получение 404 Not Found при передаче в id пустого значения null
### Шаги: Создать запрос с id null и Description "obyavlenie"
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
  "result": "laborum",
  "status": "cillum enim eiusmod"
}

## Тест-кейс 6: Неуспешное получение 404 Not Found при непередаче Description
### Шаги: Создать запрос с id 5a57bf44-4ca7-4ade-8d25-782461432e37 и без Description
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
  "result": "laborum",
  "status": "cillum enim eiusmod"
}

## Тест-кейс 7: Неуспешное получение 404 Not Found при передаче в Description пустого значения null
### Шаги: Создать запрос с id 5a57bf44-4ca7-4ade-8d25-782461432e37 и Description null
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
  "result": "laborum",
  "status": "cillum enim eiusmod"
}

## Тест-кейс 8: Неуспешное получение 404 Not Found при передаче несуществующего id
### Шаги: Создать запрос с id 6a57bf44-4ca7-4ade-8d25-782461432e37 и Description "obyavlenie"
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
  "result": "laborum",
  "status": "cillum enim eiusmod"
}

## Тест-кейс 9: Неуспешное получение 404 Not Found при передаче несуществующего Description
### Шаги: Создать запрос с id 5a57bf44-4ca7-4ade-8d25-782461432e37 и Description 5a57bf44-4ca7-4ade-8d25-782461432e37
### Ожидаемый результат: Код и статус ответа 400 Bad Request, объявление не получено
{
  "result": "laborum",
  "status": "cillum enim eiusmod"
}
