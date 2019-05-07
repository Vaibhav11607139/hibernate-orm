/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.dialect;

import java.sql.Types;

import org.hibernate.query.spi.QueryEngine;

/**
 * @author Gail Badner
 */
public class MySQL57Dialect extends MySQL55Dialect {

	public MySQL57Dialect() {
		upgradeTo57();
	}

	@Override
	public void initializeFunctionRegistry(QueryEngine queryEngine) {
		super.initializeFunctionRegistry( queryEngine );
		upgradeTo57( queryEngine );
	}

	/**
	 * @see <a href="https://dev.mysql.com/worklog/task/?id=7019">MySQL 5.7 work log</a>
	 * @return supports IN clause row value expressions
	 */
	public boolean supportsRowValueConstructorSyntaxInInList() {
		return true;
	}
}
