import {LISTAR_PROYECTOS,BORRAR_PROYECTO_POR_ID, LISTAR_PLANTILLA_POR_ID} from '../actions/actionTypes';
export function project(state = {}, action) {
    switch (action.type) {
        case LISTAR_PROYECTOS:
            return Object.assign({}, state, {
                actionType: action.type,
                respuesta: action.respuesta,
                error: false
            });
        case BORRAR_PROYECTO_POR_ID:
            return Object.assign({}, state, {
                actionType: action.type,
                respuesta: action.respuesta,
                error: false
            });    
        case LISTAR_PLANTILLA_POR_ID:
            return Object.assign({}, state, {
                actionType: action.type,
                respuesta: action.respuesta,
                error: false
            });       
        default:
            return state;
    }
}