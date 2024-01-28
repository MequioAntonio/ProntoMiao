import { UtentePrivato } from "./UtentePrivato";

export class UtentePrivatoImpl implements UtentePrivato{
    id: number | undefined;
    nome: string | undefined;
    cognome: string | undefined;
    email: string | undefined;
    indirizzo: string | undefined;
    preferenze: string | undefined;
    cf: string | undefined;
    telefono: number | undefined;
    informazioni_aggiuntive: string | undefined;
    condizioni_abitative: string | undefined;

}