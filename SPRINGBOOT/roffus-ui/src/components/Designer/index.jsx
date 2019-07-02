import React from 'react';
import {connect} from "react-redux";
import DesignerPlane2d from './DesignerPlane2d';
import DesignerHeader from './DesignerHeader';
import DesignerCategories from './DesignerCategories';
import DesignerProject from './DesignerProject';
import DesignerStateInfo from './DesignerStateInfo';
import DesignerRoom from './DesignerRoom';
import Styles from './css/styles.css';
import StylesFont from "./css/font-awesome.css";


import { INSERTAR_PLANTILLA,INSERTAR_LISTAMUEBLES,INSERTAR_PROYECTO } from '../../actions/actionTypes';
import {postPlantilla,postListaMuebles,postProyecto,fetchListaProyectos} from '../../actions/designerActions';
class Designer extends React.Component{
    constructor(props){
        super(props);
        this.state={
            proyectoActual:{nombrePaquete:'',plantilla:null,usuario:null,listaMuebles:''},
            plantillaActual:{diseno:'[{x:-0.5,y:-0.5},{x:0.5,y:-0.5},{x:0.5,y:0.5},{x:-0.5,y:0.5}]',alto:0,ancho:0,largo:0},

            existeProyecto:false,
            estadoProyecto:0,
            nombreListaMuebles:'L'+Math.round(Math.random()*5000),
            usuario:{"codUsuario":1,"nombreUsuario":null,"correo":null,"contrasena":null,"foto":null,"fnacimiento":null},
        }
        this.setPlantillaActual=this.setPlantillaActual.bind(this);
        this.setProyectoActual=this.setProyectoActual.bind(this);
        this.doGuardarProyecto=this.doGuardarProyecto.bind(this);
        this.asyncGuardarPaquete=this.asyncGuardarPaquete.bind(this);

    };
    componentDidMount(){
        window.initUI();
        window.init();
    }
    componentWillReceiveProps(nextProps){
        if(nextProps.actionType===INSERTAR_PLANTILLA){

            //console.log(nextProps.respuesta);
            this.setState({plantillaActual:nextProps.respuesta});
            this.asyncGuardarPaquete(nextProps.respuesta);
        }else if(nextProps.actionType===INSERTAR_LISTAMUEBLES){
            //console.log(nextProps.respuesta);
        }else if(nextProps.actionType===INSERTAR_PROYECTO){
            console.log(nextProps.respuesta);
            this.setState({proyectoActual:nextProps.respuesta});
            this.props.fetchListaProyectos();
        }
    }
    componentWillUnmount(){
        window.desInit();
    };
    asyncGuardarPaquete(plantilla){
        //esperó a que se responda la accion INSERTAR PLANTILLA
        this.setState((prevState)=>({
            proyectoActual:{
                
                ...prevState.proyectoActual,
                listaMuebles:this.state.nombreListaMuebles,
                usuario:this.state.usuario,
                plantilla:plantilla
            }
        }),function(){
            console.log(this.state.proyectoActual.plantilla.diseno);
            this.props.postProyecto(JSON.stringify(this.state.proyectoActual));
        });

    }
    //llamado desde los hijos
    setProyectoActual(compProyecto){
        this.setState({existeProyecto:true});
        this.setState((prevState)=>({
            proyectoActual:{
                plantilla:null,usuario:null,listaMuebles:'',
                ...compProyecto
            }
        }));
    }
    setPlantillaActual(compPlantilla){
        if(compPlantilla.diseno==null){
            this.setState((prevState)=>({
                plantillaActual:{
                    ...compPlantilla,
                    diseno:'[{x:-0.5,y:-0.5},{x:0.5,y:-0.5},{x:0.5,y:0.5},{x:-0.5,y:0.5}]'
                }
            }));
            this.setState({nombreListaMuebles:'L'+Math.round(Math.random()*5000),});
        }else{
            this.setState((prevState)=>({
                plantillaActual:{
                    ...prevState.plantillaActual,
                    ...compPlantilla
                }
            }));
        }

    }
    doGuardarProyecto(){
        if(/*this.state.estadoProyecto==0*/1){
            this.setState({estadoProyecto:1});
            let listaGenerada=window.generateListaMuebles(this.state.nombreListaMuebles);
            /*POST*/this.props.postPlantilla(JSON.stringify(this.state.plantillaActual));
            /*POST*/this.props.postListaMuebles(JSON.stringify(listaGenerada));

        }
    }
    render(){
        return(
            <React.Fragment>
                <DesignerPlane2d/>
                <DesignerHeader doGuardarProyecto={this.doGuardarProyecto}/>
                <DesignerCategories/>
                <DesignerStateInfo/>
                <DesignerRoom globalPlantilla={this.state.plantillaActual} setGlobalPlantilla={this.setPlantillaActual}/>
                <DesignerProject setGlobalPlantilla={this.setPlantillaActual} setGlobalProyecto={this.setProyectoActual} existeProyecto={this.state.existeProyecto}/>
            </React.Fragment>
        );
    }
}
const mapState = state => {
    return {respuesta: state.root.respuesta || [],actionType: state.root.actionType}
  };
  
  const mapDispatch = {
    postPlantilla,postListaMuebles,postProyecto,fetchListaProyectos
  };
 export default connect(mapState,mapDispatch)(Designer);