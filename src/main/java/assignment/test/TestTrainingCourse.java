package assignment.test;

import java.util.List;

import assignment.bean.TrainingCourses;
import assignment.dao.TraCouDAO;

public class TestTrainingCourse {

	public static void main(String[] args) {

		TraCouDAO dao = new TraCouDAO();

		/*
		 * TrainingCourses courses = new TrainingCourses(3); int row = dao.delete(3);
		 * System.out.println(row + "deleted");
		 */

		TrainingCourses courses = new TrainingCourses(4, "بي اتش بي", "PHP", 15, "programming", "programming in PHP");
		int row = dao.insert(courses);
		System.out.println(row + "inserted");

		courses = new TrainingCourses(3, "برمجة سي شارب", "C# (C-Sharp)", 15,
				"C# is a modern, object-oriented, and type-safe programming language. C# enables developers to build many types of secure and robust applications that run in .NET. C# has its roots in the C family of languages and will be immediately familiar to C, C++, Java, and JavaScript programmers. ",
				"C# is an object-oriented, component-oriented programming language. C# provides language constructs to directly support these concepts, making C# a natural language in which to create and use software components. Since its origin, C# has added features to support new workloads and emerging software design practices. At its core, C# is an object-oriented language. You define types and their behavior.\r\n"
						+ "\r\n"
						+ "Several C# features help create robust and durable applications. Garbage collection automatically reclaims memory occupied by unreachable unused objects. Nullable types guard against variables that don't refer to allocated objects. Exception handling provides a structured and extensible approach to error detection and recovery. Lambda expressions support functional programming techniques. Language Integrated Query (LINQ) syntax creates a common pattern for working with data from any source. Language support for asynchronous operations provides syntax for building distributed systems. C# has a unified type system. All C# types, including primitive types such as int and double, inherit from a single root object type. All types share a set of common operations. Values of any type can be stored, transported, and operated upon in a consistent manner. Furthermore, C# supports both user-defined reference types and value types. C# allows dynamic allocation of objects and in-line storage of lightweight structures. C# supports generic methods and types, which provide increased type safety and performance. C# provides iterators, which enable implementers of collection classes to define custom behaviors for client code.");
		row = dao.update(courses);
		System.out.println(row + "updated");

		List<TrainingCourses> TraiCouTable = dao.selectALL();
		System.out.println(TraiCouTable);

	}

}
