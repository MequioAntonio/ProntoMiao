import { Animale } from "./Animale";

export interface Annuncio {
    id : number;
    id_animale : number;
    descrizione: string;
    foto_profilo: string;
    id_centro: number;
    indirizzo: string;
    informazioni_mediche: string;
    titolo: string;
    animale : Animale;
}