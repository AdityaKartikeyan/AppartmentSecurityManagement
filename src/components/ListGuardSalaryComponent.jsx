import React, { Component } from 'react';
import GuardSalaryService from '../services/GuardSalaryService';

class ListGuardSalaryComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            guardSalary: []
        }
        this.addGuardSalary = this.addGuardSalary.bind(this);
        this.editGuardSalary = this.editGuardSalary.bind(this);
        this.deleteGuardSalary = this.deleteGuardSalary.bind(this);

    }
    baseEntity(userId) {
      this.props.history.push(`/getByPk/${userId}`);
    }
    
    editGuardSalary(userId){
      this.props.history.push(`/update-GuardSalary/${userId}`);  
    }
    componentDidMount(){
        GuardSalaryService.getGuardSalay().then((res)=>{
            this.setState({guardSalary: res.data});

        });
    }

      addGuardSalary(){
        this.props.history.push('/add-GuardSalary')
      }
      viewGuardSalary(userId) {
        this.props.history.push(`/getById/${userId}`);
      }
      deleteGuardSalary(id) {
        GuardSalaryService.deleteGuardSalary(id).then((res) => {
          this.setState({
            guardSalary: this.state.guardSalary.filter(
              (guardSalary) => guardSalary.id !== id
            ),
          });
        });
      }

    render() {
        return (
            <div>
              <h2 className="text-center">GuardSalary List</h2>
              <div className="row">
                <button className = "btn btn-primary" onClick={this.addGuardSalary}> Add Guard Detail</button>
              </div>
              <div className="row">
                <table className="table table-striped table-bordered">
                  <thead>
                    <tr>
                      <th>Name</th>
                      <th>Amount</th>
                      <th>Status</th>
                      <th>Timing</th>
                      <th>Date</th>
                      <th>Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    {this.state.guardSalary.map((guardSalary) => (
                      <tr key={guardSalary.userId}>
                        <td>{guardSalary.name}</td>
                        <td>{guardSalary.amount}</td>
                        <td>{guardSalary.status}</td>
                        <td>{guardSalary.timing}</td>
                        <td>{guardSalary.date}</td>
                        <td>
                          <button onClick = { () => this.editGuardSalary(guardSalary.userId)} className = "btn btn-info">
                            Update
                          </button>
                          <button
                      style={{ marginLeft: "10px" }}
                      onClick={() => this.deleteGuardSalary(guardSalary.id)}
                      className="btn btn-danger"
                    >
                      Delete
                    </button>
                    <button
                      style={{ marginLeft: "10px" }}
                      onClick={() =>
                        this.viewGuardSalary(guardSalary.userId)
                      }
                      className="btn btn-info"
                    >
                      View
                    </button>
                    <button
                      style={{ marginLeft: "10px" }}
                      onClick={() => this.baseEntity(guardSalary.userId)}
                      className="btn btn-info"
                    >
                      Audit
                    </button>
                        </td>
                      </tr>
                      


                    ))}
                  </tbody>
                </table>
              </div>
            </div>
          );
        }
      }

export default ListGuardSalaryComponent;

