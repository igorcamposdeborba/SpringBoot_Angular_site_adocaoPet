export interface Ong {
    id: number;
    name: string;
    email: string;
    telephone: string;
    website: string;
    responsible: string;
}

export interface Pet {
    id?: any; // REVISAR se coloco Integer.  ? significa que nem sempre tenho id (REVISAR SE VALE COLOCAR EM PET pq todo pet tem id)
    name: string;
    image: string;
    size: string;
    gender: string;
    health: string[];
    age: number;
    ong: Ong; // Composição
}