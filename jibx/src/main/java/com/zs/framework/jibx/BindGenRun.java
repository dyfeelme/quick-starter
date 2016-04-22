package com.zs.framework.jibx;

import java.util.List;

import org.jibx.binding.generator.BindGen;
import org.jibx.binding.generator.BindGenCommandLine;
import org.jibx.binding.model.BindingHolder;
import org.jibx.schema.generator.SchemaGen;

/**
 * @author DyFeelme
 *
 */
public class BindGenRun {

	public static void main(String[] args) {
		
		String []param = new String[]{"com.zs.framework.jibx.beans.Account"};
		
		try {
			generator(param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.exit(0);
	}

	private static void generator(String []args) throws Exception {
		
		BindGenCommandLine parms = new BindGenCommandLine();
        if (args.length > 0 && parms.processArgs(args)) {
            
            // generate bindings for all classes
            BindGen gen = new BindGen(parms.getGlobal());
            gen.generate(parms.getAbstract(), parms.getExtraArgs());
            BindingHolder root = gen.finish(parms.getBindingName());
            List bindings = gen.validateFiles(parms.getGeneratePath(), parms.getLocator(), root);
            if (!parms.isBindingOnly()) {
                
                // generate schemas for all bindings
                SchemaGen sgen = new SchemaGen(parms.getLocator(), parms.getGlobal(), parms.getUriNames());
                List schemas = sgen.generate(bindings);
                SchemaGen.writeSchemas(parms.getGeneratePath(), schemas);
            }
            
        } else {
            if (args.length > 0) {
                System.err.println("Terminating due to command line errors");
            } else {
                parms.printUsage();
            }
            System.exit(1);
        }

	}

}
