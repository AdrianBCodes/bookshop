import Big from 'big.js'

export enum BookCategory {
    ACTION = "Action",
    COMIC = "Comic",
    CRIME = "Crime",
    DRAMA = "Drama",
    FANTASY = "Fantasy",
    HORROR = "Horror",
    POETRY = "Poetry",
    ROMANCE = "Romance",
    SF = "Sf",
    THRILLER = "Thriller"
}

export class Book {
    id: number;
    name: string;
    description: string;
    category: BookCategory;
    price: Big;
}
