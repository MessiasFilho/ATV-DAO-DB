package Model.DAO.IMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DB.Conecxao;
import DB.DB_EXP;
import Model.DAO.SellerDAO;
import Model.Entities.Deparment;
import Model.Entities.Seller;

public class SellerDAOJDBC implements SellerDAO {

	private Connection conn;

	public SellerDAOJDBC(Connection com) {
		conn = com;
	}

	@Override
	public void insert(Seller obj) {

		PreparedStatement pt = null;
	
		try  {
			pt = conn.prepareStatement("INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS );
			
			
			pt.setString(1, obj.getName());
			pt.setString(2, obj.getEmail());
			pt.setDate(3,new java.sql.Date(obj.getBirthDate().getTime()));
			pt.setDouble(4, obj.getBaseSalary());
			pt.setInt(5,obj.getDep().getID());
			
			// verificar se as linhas foram  alteradas 
			
			int Linhas = pt.executeUpdate(); 
			
			if (Linhas > 0  ) {
				ResultSet rs1 = pt.getGeneratedKeys(); 
					if (rs1.next()) {
						int id = rs1.getInt(1); 
						obj.setId(id);
					}
					Conecxao.closeResultSet(rs1);
				
				
			}else {
				throw new DB_EXP(" Erro desconhecido nem uma linha foi alterada "); 
			}
			
		}catch (SQLException e  ) {
			throw new DB_EXP(e.getMessage()); 
		}finally {
			Conecxao.closeStatement(pt);
		}
		
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DeletById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {

		PreparedStatement pt = null;
		ResultSet rs = null;

		try {
			pt = conn.prepareStatement(
					   "SELECT seller.*,department.Name as DepName " 
					 + "FROM seller INNER JOIN department "
					 + "ON seller.DepartmentId = department.Id " 
					 + "WHERE seller.Id = ?");

			pt.setInt(1, id);

			rs = pt.executeQuery();

			if (rs.next()) {
				Deparment dep = InstanceDepartment(rs);
				Seller obj  = InstanceSeller(rs , dep ); 

				return obj;
			}
			
			return null;
			
		} catch (SQLException e) {
			throw new DB_EXP(e.getMessage());

		} finally {
			Conecxao.closeStatement(pt);
			Conecxao.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Seller> findALL() {
		PreparedStatement ps = null ; 
		ResultSet rs = null ; 
		
		try {
			ps = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name"); 
			
			rs = ps.executeQuery(); 
			List <Seller > list = new ArrayList<>();
			Map <Integer , Deparment  > map = new HashMap <>(); 
			
			while (rs.next() ) {
				
				
				Deparment dep = map.get(rs.getInt("DepartmentId"));  
				
				if (dep == null  ) {
					dep = InstanceDepartment(rs); 
					map.put(rs.getInt("DepartmentId"), dep); 
				}
				
				Seller sel = InstanceSeller(rs, dep ); 
				
				list.add(sel); 
			}
			return list ; 
			
		} catch (SQLException e) {
			throw new DB_EXP(e.getMessage());

		} finally {
			Conecxao.closeStatement(ps);
			Conecxao.closeResultSet(rs);
		}

		
		
		
		
		
		
		
	}

	
	private  Deparment InstanceDepartment (ResultSet rs  ) throws SQLException  { 
		Deparment dep = new Deparment (); 
		dep.setID(rs.getInt("DepartmentId"));
		dep.setNome(rs.getString("DepName"));
		return dep ; 
		
		
	}
	private Seller InstanceSeller (ResultSet rs , Deparment dep  ) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setDep(dep);
		
		return obj ; 
		
	}

	@Override
	public List<Seller> FindByDepartment(Deparment dep) {
		PreparedStatement st = null ; 
		ResultSet rs = null ; 
		
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name"); 
			st.setInt(1, dep.getID());
			rs = st.executeQuery(); 
			
			List <Seller> list = new ArrayList<>(); 
			Map <Integer , Deparment  > map = new HashMap <>(); 
			
			while (rs.next()) {
				
				Deparment depar = map.get(rs.getInt("DepartmentId"))  ; 
				
				if (depar == null  ) {
					 depar = InstanceDepartment (rs);  
					 map.put(rs.getInt("DepartmentId"),depar); 
				}
				
				
				Seller sel = InstanceSeller(rs , depar ); 
				list.add(sel);
				
			}
			return list; 
			
		}catch (SQLException e) {
			throw new DB_EXP(e.getMessage());

		} finally {
			Conecxao.closeStatement(st);
			Conecxao.closeResultSet(rs);
		}
		
		
		
	}
	
}
