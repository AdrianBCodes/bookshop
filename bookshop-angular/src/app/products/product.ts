import Big from "big.js";

export interface Product {
    id: string,
    name: string,
    price: Big
}