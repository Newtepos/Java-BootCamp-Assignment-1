# Java-BootCamp-Assignment-1
## InitialSetup
### Stubby4j for ExternalApi Mockup
- [Download](www.google.com) Stubby4j 
- Run command java -jar stubby4j-x.x.x.jar -d BankApi.yaml (following your stubbh4j version)
- Finish ExternalApi Setup

## API List
### 1. Login
`GET /login/`

Body
```JSON
{
    "username": "johndoe",
    "password" : "1234"
}
```
Response
```JSON
{
    "message": "login success"
}
```  

### 2. Serach All Product by words
`GET /product?p=product`

Body
```
```
Response
```JSON
{
   [
    {
        "id": 5,
        "productName": "King Orange",
        "price": 20.0
    },
    {
        "id": 6,
        "productName": "Queen Orange",
        "price": 10.0
    }
]
}
```

### 3. Get Product By Id
`GET /product/{id}`

Body
```
```
Response
```JSON
{
    {
    "id": 6,
    "productName": "Queen Orange",
    "price": 10.0
}
}
```

### 4. Add Product to UserCart
`POST /user/{userId}/cart/add/{productId}/{quantity}

Body
```
```
Response
```JSON
{
    "message": "Product Added to you cart!!"
}
``` 

### 5. Get All Products in UserCart
`GET /user/{userId}/cart

Body
```
```
Response
```JSON
[
    {
        "id": 7,
        "quantity": 20,
        "totalPrice": 400.0,
        "product": {
            "id": 5,
            "productName": "King Orange",
            "price": 20.0
        }
    }
]
```

### 6. UserCart Checkout
`GET /user/{userId}/cart/checkout

Body
```
```
Response
```JSON
{
    "date": "2022-02-27T10:46:16.339+00:00",
    "name": "johndoe",
    "billAddress": {
        "id": 2,
        "province": "Bangkok",
        "district": "Klongsam-parvet",
        "zipCode": 10520
    },
    "paymentAddress": {
        "id": 4,
        "cardHolder": "Supakit",
        "cardNumber": 1231233
    },
    "cartItemList": [
        {
            "id": 7,
            "quantity": 20,
            "totalPrice": 400.0,
            "product": {
                "id": 5,
                "productName": "King Orange",
                "price": 20.0
            }
        }
    ]
}
```

### 7. ExternalApi Mockup Check
`GET localhost:8882/checkout

Body
```
```
Response
```JSON
{
    "message": "Bank Pay Completed"
}
```


## Main Flow Process
[![](https://mermaid.ink/img/pako:eNpN0MFuwyAMANBfsbiMSu0P5FCpTdJeNrVStlsuCLwEJQEE5jA1_fexkWyBC7KfDfjBpFXICtZ54Xp4r1oDaZ14Q8LTDg6HI8wn50BIiSHMZ_5qO23uosNdpudsfsMQYmYlfxN-QIINLDO8e6uiJChHLQdUc8XXyMZWy8VKwZolC2V60l9dzT8C-pcATW-d06bL6U2TOjcpe5SDjf-VF54bLfFFX7K-WoKbV-ihQhJ6nK8cjUomb7ZnE_pJaJVm9vipbBn1OGHLinRU6dcta80zueiUIKyVJutZ8SnGgHsmItnmy0hWkI-4okqLNP9pUc9vMbGD8g)](https://mermaid-js.github.io/mermaid-live-editor/edit/#pako:eNpN0MFuwyAMANBfsbiMSu0P5FCpTdJeNrVStlsuCLwEJQEE5jA1_fexkWyBC7KfDfjBpFXICtZ54Xp4r1oDaZ14Q8LTDg6HI8wn50BIiSHMZ_5qO23uosNdpudsfsMQYmYlfxN-QIINLDO8e6uiJChHLQdUc8XXyMZWy8VKwZolC2V60l9dzT8C-pcATW-d06bL6U2TOjcpe5SDjf-VF54bLfFFX7K-WoKbV-ihQhJ6nK8cjUomb7ZnE_pJaJVm9vipbBn1OGHLinRU6dcta80zueiUIKyVJutZ8SnGgHsmItnmy0hWkI-4okqLNP9pUc9vMbGD8g)


## Login Process
[![](https://mermaid.ink/img/pako:eNplkcFOwzAMhl_FygE2aXuBHkBsrbQNmJAKB9Ry8BrTVbRJlLibULN3J2s2CUQOkfX_n3_LySAqLUkkorZo9vCalgrCeZjkjJanMJ_f-SPt0BjAqiLnPCyKJ103Cl6wpo-IL84cLAtSTBZ6F64bMOjcUVt5YZYjkxbGhhRox4hdz6zVBUhHwOeEttr7rHgLMbcOUmTcobuOyiJlqWroQBJCmtHKkV8NsSRQmkH1bQv3p9izij1b7Zd_hHdyfl1s8dDUyASs4RntF_Hv1dYjuin-O5vReZxkSk7PSlRLJWaiI9thI8OzDqMjeE8dlSIJpQxBpSjVKXC9kWFwJhvWViSf2DqaCexZ59-qEgnbnq5Q2mD4oi6Kpx9R6YwD)](https://mermaid-js.github.io/mermaid-live-editor/edit/#pako:eNplkcFOwzAMhl_FygE2aXuBHkBsrbQNmJAKB9Ry8BrTVbRJlLibULN3J2s2CUQOkfX_n3_LySAqLUkkorZo9vCalgrCeZjkjJanMJ_f-SPt0BjAqiLnPCyKJ103Cl6wpo-IL84cLAtSTBZ6F64bMOjcUVt5YZYjkxbGhhRox4hdz6zVBUhHwOeEttr7rHgLMbcOUmTcobuOyiJlqWroQBJCmtHKkV8NsSRQmkH1bQv3p9izij1b7Zd_hHdyfl1s8dDUyASs4RntF_Hv1dYjuin-O5vReZxkSk7PSlRLJWaiI9thI8OzDqMjeE8dlSIJpQxBpSjVKXC9kWFwJhvWViSf2DqaCexZ59-qEgnbnq5Q2mD4oi6Kpx9R6YwD)

## Search Product in Market Process
[![](https://mermaid.ink/img/pako:eNpdkctqwzAQRX9l0EqB5Ae8aKntvEpbQtNNqbqYWhNHxB4ZSS6EOP9exXZSyG6498xDVydRWE0iEaXDZg8fueInmU5gNnuAVL6iO1CADZY0UZz2aibX7MkF0BgQDMOWHBZ7WBiqdKSynprLUU7bECxDVpniQBd_3vvdltBFe-OsbovQLeRYQR7H_qC_LFwM6NV5J9_YuLtbnu4lMB64rSp4PCteDm2f5LvySxvfVHgEtkzQDG3fisvhyhv8ZrudzEf2Ov3F-ODjHbueWd1O_H_MauzGX1NioG59Y8bM1j3wLLOJmIqaXI1Gx7RPigGUCHuqSYkkljpGrYTic-TaJmZLc22CdSLZYeVpKrANdnvkQiTBtXSFcoPx5-pBPP8BWIaZ-w)](https://mermaid-js.github.io/mermaid-live-editor/edit/#pako:eNpdkctqwzAQRX9l0EqB5Ae8aKntvEpbQtNNqbqYWhNHxB4ZSS6EOP9exXZSyG6498xDVydRWE0iEaXDZg8fueInmU5gNnuAVL6iO1CADZY0UZz2aibX7MkF0BgQDMOWHBZ7WBiqdKSynprLUU7bECxDVpniQBd_3vvdltBFe-OsbovQLeRYQR7H_qC_LFwM6NV5J9_YuLtbnu4lMB64rSp4PCteDm2f5LvySxvfVHgEtkzQDG3fisvhyhv8ZrudzEf2Ov3F-ODjHbueWd1O_H_MauzGX1NioG59Y8bM1j3wLLOJmIqaXI1Gx7RPigGUCHuqSYkkljpGrYTic-TaJmZLc22CdSLZYeVpKrANdnvkQiTBtXSFcoPx5-pBPP8BWIaZ-w)

## Add Product to Cart Process
[![](https://mermaid.ink/img/pako:eNptkstOwzAQRX_F8oZU0AXbLkAQF_qACrWwQDWLwR4aq4kd-YFUNf13HKeNCmIXzT135s7EeyqMRDqiGwt1QV4Z13dZPiDD4Q25z16skUF48gIbHHB9n8qNQ7CiIPVR_NyRKWvyHmbg4RNca8g7w0lZoquNdtiwjClXl7AjvQmdsKr2yujoY8k3zu6k7AlvSA7Wk7xUYosyUuOu-wK-1QY8Ng_Zm0N74RIX9YekP6Zq5z2L9pjEyb4ARxxU2K-jNBEte3vgetJNeEfXTH-FuSTXg15emKbIhMWY4bxLaMeKLkrRH0Kgc4QZjc2M6-l_5WyJQwGlCGXbcBWqCmx7KCXa3LNkma9PB_ylt2PbRT-4nifuaZ0XKLYmxN8UvDdxt-58kXj6c77n9dH6nIRFxgb0ilZoK1AyvpA914Rw6guskNNR_JRgt5xyfYhcqGVsMpbKG0tHX1A6vKIQvFnttKAjbwOeIKYgvrbqSB1-ANl61sA)](https://mermaid-js.github.io/mermaid-live-editor/edit/#pako:eNptkstOwzAQRX_F8oZU0AXbLkAQF_qACrWwQDWLwR4aq4kd-YFUNf13HKeNCmIXzT135s7EeyqMRDqiGwt1QV4Z13dZPiDD4Q25z16skUF48gIbHHB9n8qNQ7CiIPVR_NyRKWvyHmbg4RNca8g7w0lZoquNdtiwjClXl7AjvQmdsKr2yujoY8k3zu6k7AlvSA7Wk7xUYosyUuOu-wK-1QY8Ng_Zm0N74RIX9YekP6Zq5z2L9pjEyb4ARxxU2K-jNBEte3vgetJNeEfXTH-FuSTXg15emKbIhMWY4bxLaMeKLkrRH0Kgc4QZjc2M6-l_5WyJQwGlCGXbcBWqCmx7KCXa3LNkma9PB_ylt2PbRT-4nifuaZ0XKLYmxN8UvDdxt-58kXj6c77n9dH6nIRFxgb0ilZoK1AyvpA914Rw6guskNNR_JRgt5xyfYhcqGVsMpbKG0tHX1A6vKIQvFnttKAjbwOeIKYgvrbqSB1-ANl61sA)


## Send request to ExternalApi(Bank)
[![](https://mermaid.ink/img/pako:eNpFkUtvgzAQhP_KyofKkRL1zqES4IT21KiPG5ct3oIVMK69SEUh_70OD9Una-eb2ZF9FVWvSSSi9uga-FClhXhSqXZwODxBJnP0DGesabdI2TyfAqGvGgiNcc7YGh7A4diRZUCtPYUw5fIzkAeFjF8YNnu-2GtiiJTrbaBJSWWCa3GEF6YOHiEzbXsPTZeoODkv4WuI2jpYHVN-Bgo8nWSG9gLHXyZvsYXUmZU-LXTsB2Goqnu3QhZk0SMTvHodW76tXVZL8d-yn3VNjKadnuXR6plZuNKKvejId2h0fMTrrAhuqKNSJPGq0V9KUdpb5Aan48KjNtx7kXxjG2gvcOD-fbSVSNgPtEHKYPyQbqVuf1qtiLk)](https://mermaid-js.github.io/mermaid-live-editor/edit/#pako:eNpFkUtvgzAQhP_KyofKkRL1zqES4IT21KiPG5ct3oIVMK69SEUh_70OD9Una-eb2ZF9FVWvSSSi9uga-FClhXhSqXZwODxBJnP0DGesabdI2TyfAqGvGgiNcc7YGh7A4diRZUCtPYUw5fIzkAeFjF8YNnu-2GtiiJTrbaBJSWWCa3GEF6YOHiEzbXsPTZeoODkv4WuI2jpYHVN-Bgo8nWSG9gLHXyZvsYXUmZU-LXTsB2Goqnu3QhZk0SMTvHodW76tXVZL8d-yn3VNjKadnuXR6plZuNKKvejId2h0fMTrrAhuqKNSJPGq0V9KUdpb5Aan48KjNtx7kXxjG2gvcOD-fbSVSNgPtEHKYPyQbqVuf1qtiLk)
