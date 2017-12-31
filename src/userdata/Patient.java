package userdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javaBean.*;
import DAO.Query;

public class Patient {
	public ArrayList<MedicalHistoryBean> getMedicalHiostory(int userId) throws SQLException{
		ArrayList<MedicalHistoryBean> list=new ArrayList<MedicalHistoryBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getPatientMedicalHistory(userId);
		while(result.next()){
			MedicalHistoryBean ob=new MedicalHistoryBean();
			ob.setId(result.getInt(1));
			ob.setFileName(result.getString(2));
			ob.setDescription(result.getString(3));
			ob.setDateByPatient(result.getString(4));
			ob.setDateOfUpload(result.getString(5));
			list.add(ob);
		}
		return list;
	}
	
	public ArrayList<PrescriptionBean> getPrscription(int userId) throws SQLException{
		ArrayList<PrescriptionBean> list=new ArrayList<PrescriptionBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getPatientPrescription(userId);
		while(result.next()){
			PrescriptionBean ob=new PrescriptionBean();
			ob.setId(result.getInt(1));
			ob.setName(result.getString(2));
			ob.setSympton(result.getString(3));
			ob.setDiagnosis(result.getString(4));
			ob.setDate(result.getString(5));
			list.add(ob);
		}
		return list;
	}
	/*public ArrayList<PrescriptionBean> getSPrscription(String []words, int j,int uid) throws SQLException{
		ArrayList<PrescriptionBean> list=new ArrayList<PrescriptionBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getPatientPrescription(words,j,uid);
		System.out.println("pppppppppppppppppppppppppppppppppppp");
		while(result.next()){
			System.out.println("ssssssssssssmmmmmmmmmmmmmmmmmmmm");
			PrescriptionBean ob=new PrescriptionBean();
			ob.setId(result.getInt(1));
			ob.setName(result.getString(2));
			ob.setSympton(result.getString(3));
			ob.setDiagnosis(result.getString(4));
			ob.setDate(result.getString(5));
			list.add(ob);
		}
		return list;
	}
	*/
	public ArrayList<PrescriptionBean> getMedicine(int prescriptionId) throws SQLException{
		ArrayList<PrescriptionBean> list=new ArrayList<PrescriptionBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getMedicine(prescriptionId);
		while(result.next()){
			PrescriptionBean ob=new PrescriptionBean();
			ob.setMedicine(result.getString(1));
			ob.setDosage(result.getString(2));
			list.add(ob);
		}
		return list;
	}
	
	public ArrayList<PatientSelfDescriptionBean> getSelfDescription(int userId) throws SQLException{
		ArrayList<PatientSelfDescriptionBean> list=new ArrayList<PatientSelfDescriptionBean>();
		Query query=Query.getInstance();
		ResultSet result=query.getPatientDescription(userId);
		while(result.next()){
			PatientSelfDescriptionBean ob=new PatientSelfDescriptionBean();
			ob.setDescription(result.getString(1));
			ob.setDate(result.getString(2));
			list.add(ob);
		}
		return list;
	}
}
