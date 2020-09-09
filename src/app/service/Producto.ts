export interface Producto{

    productos:{
        _id ?: string,
        nombre: string,
        precioUni: DoubleRange,
        descripcion: string,
        categoria : string
    },
    conteo: number
}

